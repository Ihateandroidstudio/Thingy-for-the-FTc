package org.firstinspires.ftc.teamcode.Irrelevant.mechanisms;
import android.text.method.Touch;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
@Disabled

public class TestBench {
    private DigitalChannel TouchSensor; // touchSenserIntake
    private DcMotor motor; // LinearSlideMotor0
    private double ticksPerRev; // revolution

    public void init(HardwareMap hwMap) {
        // Touch Sensor
        TouchSensor = hwMap.get(DigitalChannel.class, "touchsensor");
        TouchSensor.setMode(DigitalChannel.Mode.INPUT);
        // DC motor
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRev = motor.getMotorType().getTicksPerRev();
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    // ---------- Touch Sensor -------------
    public boolean isTouchSensorPressed() {
        return !TouchSensor.getState();
    }

    public boolean IsTouchSensorReleased() {
        return TouchSensor.getState();
    }

    // -------- Dc Motor ------------
    public void setMotorSpeed(double speed) {
        // accepts values from -1.0 = 1.0
        motor.setPower(speed);
    }

    public double getMotorRevs() {
        return motor.getCurrentPosition() / ticksPerRev; // normalizing ticks to revolution 2:1
    }

    public void setMotorZeroBehaviour(DcMotor.ZeroPowerBehavior zeroBehaviour) {
        motor.setZeroPowerBehavior(zeroBehaviour);
    }
}