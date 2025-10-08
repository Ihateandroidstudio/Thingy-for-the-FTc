package org.firstinspires.ftc.teamcode.mechanisms;

import android.text.method.Touch;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench {
    private DigitalChannel TouchSensor; // touchSenserIntake

    public void init(HardwareMap hwMap) {
        TouchSensor = hwMap.get(DigitalChannel.class,"touch_sensor");
        TouchSensor.setMode(DigitalChannel.Mode.INPUT);

    }

    public boolean IsTouchSensorPressed() {
        return !TouchSensor.getState();
    }

    public boolean IsTouchSensorReleased() {
        return TouchSensor.getState();
    }
}
