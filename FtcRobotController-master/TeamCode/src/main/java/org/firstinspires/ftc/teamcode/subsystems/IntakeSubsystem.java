package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

// Controls the motor that sucks in and spits out game pieces
// ⚠️ IMPORTANT: If your intake spins backwards, change FORWARD to REVERSE on line 17!
public class IntakeSubsystem extends SubsystemBase {
    private final DcMotor intakeMotor;

    public IntakeSubsystem(HardwareMap hardwareMap) {
        // Find the intake motor in the robot's configuration ("intakeMotor" is the name in your config)
        intakeMotor = hardwareMap.get(DcMotor.class, "intakeMotor");

        // Set which way is "forward" for this motor (use REVERSE if your intake runs backwards)
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);

        // Make motor stop quickly instead of coasting to a stop
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Reset the motor's position counter to 0 (erases previous movement history)
        intakeMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    // Set how fast the intake motor spins
    // 1.0 = full speed forward, -1.0 = full speed backward, 0.0 = stop
    public void setPower(double power) {
        // Keep power between -1.0 and 1.0 (safety check)
        power = Math.max(-1.0, Math.min(1.0, power));
        intakeMotor.setPower(power);
    }

    // Suck game pieces into the robot
    public void intakeIn() {
        setPower(1.0);
    }

    // Push game pieces out of the robot
    public void intakeOut() {
        setPower(-1.0);
    }

    // Stop the intake motor
    public void stop() {
        setPower(0.0);
    }

    // Check how fast the motor is currently running (for debugging)
    public double getCurrentPower() {
        return intakeMotor.getPower();
    }
}