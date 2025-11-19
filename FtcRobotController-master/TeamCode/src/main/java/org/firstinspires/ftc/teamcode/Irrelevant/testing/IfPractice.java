package org.firstinspires.ftc.teamcode.Irrelevant.testing;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class IfPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double motorSpeed = gamepad1.left_stick_y;

        if (!gamepad1.a) {
            motorSpeed *= 0.5;
        }

        telemetry.addData("Left Stick value", motorSpeed);
}

}

/*
1. make a turbo button. If the button is NOT pressed, multiple the motor speed by 0.5, otherwise,
use standard speed
 */

/*

AND - && if (leftY < 0.5 && leftY > 0) {
OR  || if (leftY < 0 || rightY < 0) {
NOT ! if (clawClosed) {

 */