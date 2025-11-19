package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

// This command reads the gamepad and tells the robot how to move
// It runs continuously during teleop to keep checking for input
public class DriveCommand extends CommandBase {
    // Store the drive system and gamepad so we can use them
    private final DriveSubsystem driveSubsystem;
    private final GamepadEx gamepadEx;

    // Constructor: set up the command with the drive system and gamepad
    public DriveCommand(DriveSubsystem driveSubsystem, GamepadEx gamepadEx) {
        // Save these so we can use them later
        this.driveSubsystem = driveSubsystem;
        this.gamepadEx = gamepadEx;

        // Tell the scheduler this command needs the drive system
        // (prevents other commands from interfering)
        addRequirements(driveSubsystem);
    }

    // This method runs over and over (about 50 times per second)
    // It reads the gamepad and moves the robot
    @Override
    public void execute() {
        // Read the gamepad sticks (values go from -1.0 to 1.0)
        double forward = -gamepadEx.getLeftY();  // Left stick up/down (negative because Y is backwards)
        double strafe = gamepadEx.getLeftX();    // Left stick left/right
        double rotate = gamepadEx.getRightX();   // Right stick left/right

        // Ignore very small movements (prevents accidental drift)
        if (Math.abs(forward) < 0.05) forward = 0;
        if (Math.abs(strafe) < 0.05) strafe = 0;
        if (Math.abs(rotate) < 0.05) rotate = 0;

        // Tell the drive system to move the robot
        driveSubsystem.drive(forward, strafe, rotate);
    }

    @Override
    public boolean isFinished() {
        // Never finish - we always want to be reading the gamepad!
        return false;
    }
}
