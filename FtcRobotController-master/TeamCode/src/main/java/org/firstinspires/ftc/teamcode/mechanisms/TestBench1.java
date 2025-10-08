package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench1 {
    public boolean isTouchSensorPressed;
    private DcMotor motor; // LinearSlideMotor0
    private double ticksPerRev; // revolution

    public void init(HardwareMap hwMap) {
        //touch sensor code

        // DC motor
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRev = motor.getMotorType().getTicksPerRev();
    }

    public void setMotorSpeed(double speed) {
        // accepts values from -1.0 = 1.0
        motor.setPower(speed);
    }

    public double getMotorRevs() {
        return motor.getCurrentPosition() / ticksPerRev; // normalizing ticks to revolution 2:1
    }
}

