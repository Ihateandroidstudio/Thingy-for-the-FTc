package org.firstinspires.ftc.teamcode.commands;

// Import the necessary classes from FTCLib and our project
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

/**
 * DriveCommand - This is a command that controls the robot's driving
 * <p>
 * In FTCLib's command-based programming:
 * - Commands contain the logic for what the robot should DO
 * - Subsystems contain the hardware and HOW to do it
 * - This command tells the drive subsystem to move based on gamepad input
 */
public class DriveCommand extends CommandBase {
    // Store references to the subsystem and gamepad we need
    private final DriveSubsystem driveSubsystem;  // The drive system we're controlling
    private final GamepadEx gamepadEx;            // The gamepad we're reading input from

    /**
     * Constructor - This runs once when the command is created
     * @param driveSubsystem The robot's drive system
     * @param gamepadEx The gamepad controller
     */
    public DriveCommand(DriveSubsystem driveSubsystem, GamepadEx gamepadEx) {
        // Save the subsystem and gamepad so we can use them later
        this.driveSubsystem = driveSubsystem;
        this.gamepadEx = gamepadEx;

        // Tell the command scheduler that this command "requires" the drive subsystem
        // This prevents other commands from using the drive system at the same time
        addRequirements(driveSubsystem);
    }

    /**
     * execute() - This method runs repeatedly (about 50 times per second) while the command is active
     * This is where we read the gamepad and tell the robot how to move
     */
    @Override
    public void execute() {
        // Read the gamepad joystick values (each value is between -1.0 and 1.0)
        double forward = -gamepadEx.getLeftY();  // Left stick Y-axis: forward/backward (negative because Y is inverted)
        double strafe = gamepadEx.getLeftX();    // Left stick X-axis: left/right (strafing)
        double rotate = gamepadEx.getRightX();   // Right stick X-axis: rotation (turning)

        driveSubsystem.drive(forward, strafe, rotate);
    }

    /**
     * isFinished() - This tells the command scheduler when this command should stop
     *
     * @return true if the command should end, false if it should keep running
     */
    @Override
    public boolean isFinished() {
        // Return false because we want this command to run continuously during teleop
        // The robot should always be listening for gamepad input!
        return false;
    }
}
