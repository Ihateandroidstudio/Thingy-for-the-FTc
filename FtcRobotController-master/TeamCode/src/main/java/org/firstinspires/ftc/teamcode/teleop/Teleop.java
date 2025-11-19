package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.commands.IntakeCommand;

// Main teleop program - this runs when drivers control the robot
@TeleOp(name = "MainTeleop")
public class Teleop extends CommandOpMode {
    // Robot systems
    private DriveSubsystem drive_subsystem;        // Controls the 4 drive wheels
    private IntakeSubsystem intake_subsystem;      // Controls the intake motor

    // Controllers (2 people can control the robot)
    private GamepadEx drive_controller;            // Controller 1: drives the robot
    private GamepadEx intake_controller;           // Controller 2: operates the intake

    @Override
    public void initialize() {
        // Connect to both controllers
        drive_controller = new GamepadEx(gamepad1);   // Driver uses controller 1
        intake_controller = new GamepadEx(gamepad2);  // Operator uses controller 2

        // Set up robot hardware
        drive_subsystem = new DriveSubsystem(hardwareMap);
        intake_subsystem = new IntakeSubsystem(hardwareMap);

        // Make driving always active on controller 1
        drive_subsystem.setDefaultCommand(new DriveCommand(drive_subsystem, drive_controller));

        // Set up intake buttons on controller 2
        // A button = suck in game pieces
        intake_controller.getGamepadButton(GamepadKeys.Button.A)
                .whileHeld(new IntakeCommand(intake_subsystem, 1.0));

        // B button = spit out game pieces
        intake_controller.getGamepadButton(GamepadKeys.Button.B)
                .whileHeld(new IntakeCommand(intake_subsystem, -1.0));
    }
}
