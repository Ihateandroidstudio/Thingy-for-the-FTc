package org.firstinspires.ftc.teamcode.teleop;

// Import necessary classes from FTCLib, FTC SDK, and our project

import com.arcrobotics.ftclib.command.CommandOpMode;       // Base class for command-based OpModes
import com.arcrobotics.ftclib.command.button.Trigger;      // For button triggers (not used yet, but imported)
import com.arcrobotics.ftclib.gamepad.GamepadEx;          // Enhanced gamepad with more features
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;    // Annotation to mark this as a TeleOp

import org.firstinspires.ftc.teamcode.commands.DriveCommand;     // Our custom drive command
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem; // Our drive subsystem

/**
 * Teleop - This is the main TeleOp (remote control) program for our robot
 * <p>
 * What happens here:
 * 1. We set up our robot's subsystems (drive system)
 * 2. We set up our controllers (gamepad)
 * 3. We tell the robot what to do by default (drive with gamepad input)
 * <p>
 * The @TeleOp annotation tells the Driver Station this is a TeleOp program
 * and gives it the name "MainTeleop" that will appear on the Driver Station
 */
@TeleOp(name = "MainTeleop")
public class Teleop extends CommandOpMode {  // CommandOpMode is the base class for command-based programs

    // Declare our robot components (but don't create them yet - that happens in initialize())
    private DriveSubsystem drive_subsystem;  // The robot's drive system (motors, wheels, etc.)
    private GamepadEx drive_controller;      // The enhanced gamepad we'll use to control the robot

    /**
     * initialize() - This method runs ONCE when you press the INIT button on the Driver Station
     * This is where we set up everything our robot needs before the match starts
     */
    @Override
    public void initialize() {
        // Create our gamepad controller using gamepad1 (the first controller plugged in)
        drive_controller = new GamepadEx(gamepad1);

        // Create our drive subsystem and give it access to the robot's hardware
        // hardwareMap is provided by FTC and contains all the motors, sensors, etc.
        drive_subsystem = new DriveSubsystem(hardwareMap);

        // Set the "default command" for the drive subsystem
        // A default command runs automatically whenever no other command is using the subsystem
        // This means the robot will always be listening for gamepad input to drive around
        drive_subsystem.setDefaultCommand(new DriveCommand(drive_subsystem, drive_controller));

        // That's it! The command scheduler will now automatically:
        // 1. Run our DriveCommand continuously during TeleOp
        // 2. Read gamepad input and move the robot accordingly
        // 3. Handle all the timing and scheduling for us
    }

    // Note: We don't need to override loop() or any other methods!
    // The CommandOpMode and our DriveCommand handle everything automatically
}
