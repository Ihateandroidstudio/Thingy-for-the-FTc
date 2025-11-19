package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

// Runs the intake motor while a button is held down
// Automatically stops when the button is released
public class IntakeCommand extends CommandBase {
    private final IntakeSubsystem intakeSubsystem;
    private final double power;

    // Create a new intake command
    // power: positive = suck in, negative = spit out, 0 = stop
    public IntakeCommand(IntakeSubsystem intakeSubsystem, double power) {
        this.intakeSubsystem = intakeSubsystem;
        this.power = power;

        // Tell the robot this command controls the intake system
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {
        // Make sure intake is stopped when we start
        intakeSubsystem.stop();
    }

    @Override
    public void execute() {
        // Run the intake at the speed we want (this repeats many times per second)
        intakeSubsystem.setPower(power);
    }

    @Override
    public void end(boolean interrupted) {
        // Always stop the intake when done
        // This happens when the button is released or something goes wrong
        intakeSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        // Never finish on our own - only stop when button is released
        return false;
    }
}