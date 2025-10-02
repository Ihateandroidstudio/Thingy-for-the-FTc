package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;
@TeleOp
public class TouchSensorPractice extends OpMode {
    TestBench bench = new TestBench() ;

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        String touchSensorstate = "not pressed";
                if (bench.IsTouchSensorPressed()) {
                    touchSensorstate = "pressed";
                }
        telemetry.addData("touch sensor state", touchSensorstate);
    }

    /*
    1. create a new "getter" method in your test bench class called "IsTouchSensorPressed" return true
    if the touch sensor is NOT pressed.
    2.in your telemetry opmode, have telemetry state "pressed!" and "notpressed! " instead of true or false
     */
}//sgoihefaio;jrsgojifjiofa
