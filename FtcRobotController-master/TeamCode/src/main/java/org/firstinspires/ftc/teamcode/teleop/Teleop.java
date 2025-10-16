package org.firstinspires.ftc.teamcode.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

@TeleOp(name = "MainTeleop")
public class Teleop extends CommandOpMode {
    private DriveSubsystem drive_subsystem;
    private GamepadEx drive_controller;

    private Trigger left_trigger,right_trigger;

    @Override
    public void initialize() {

        drive_controller = new GamepadEx(gamepad1);

        drive_subsystem = new DriveSubsystem(hardwareMap);
    }


}
