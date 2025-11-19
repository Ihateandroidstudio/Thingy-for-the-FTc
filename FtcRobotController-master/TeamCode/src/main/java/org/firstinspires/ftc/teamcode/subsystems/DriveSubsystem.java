package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

// This class controls the robot's wheels and movement
public class DriveSubsystem extends SubsystemBase {
    // The four motors that spin the wheels
    private final Motor frontLeft;
    private final Motor frontRight;
    private final Motor backRight;
    private final Motor backLeft;

    // FTCLib helper that makes mecanum driving easier
    private final MecanumDrive drive;

    // Ignore tiny joystick movements (prevents drift)
    private static final double DEADZONE = 0.05;

    // Make the robot go slower for precise control (1.0 = full speed)
    private static final double DRIVE_SCALE = 1.0;

    public DriveSubsystem(HardwareMap hardwareMap) {
        // Connect to the four wheel motors in the robot configuration
        frontLeft = new Motor(hardwareMap, "frontLeft", Motor.GoBILDA.RPM_312);
        frontRight = new Motor(hardwareMap, "frontRight", Motor.GoBILDA.RPM_312);
        backRight = new Motor(hardwareMap, "backRight", Motor.GoBILDA.RPM_312);
        backLeft = new Motor(hardwareMap, "backLeft", Motor.GoBILDA.RPM_312);

        // Make motors brake when power is 0 (instead of coasting)
        frontLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        // Right side motors spin backwards, so flip them
        frontRight.setInverted(true);
        backRight.setInverted(true);

        // Reset encoder counts to 0
        frontLeft.resetEncoder();
        frontRight.resetEncoder();
        backLeft.resetEncoder();
        backRight.resetEncoder();

        // Create the mecanum drive controller with our motors
        drive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);
    }

    // This method makes the robot move based on joystick input
    // forward: + = forward, - = backward
    // strafe: + = right, - = left  
    // rotate: + = turn right, - = turn left
    public void drive(double forward, double strafe, double rotate) {
        // Ignore tiny movements that might cause drift
        forward = applyDeadzone(forward);
        strafe = applyDeadzone(strafe);
        rotate = applyDeadzone(rotate);

        // Scale down the speed if needed
        forward *= DRIVE_SCALE;
        strafe *= DRIVE_SCALE;
        rotate *= DRIVE_SCALE;

        // Tell the mecanum drive to move the robot
        drive.driveRobotCentric(strafe, forward, rotate);
    }

    // Helper method: returns 0 if the value is too small, otherwise returns the original value
    private double applyDeadzone(double value) {
        return Math.abs(value) < DEADZONE ? 0 : value;
    }
}