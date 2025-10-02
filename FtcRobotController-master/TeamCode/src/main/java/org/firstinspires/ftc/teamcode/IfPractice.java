package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class IfPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double lefty = gamepad1.left_stick_y;

        if (lefty < 0) {
            telemetry.addData("Left Stick", "is Negative");
        }
        else {
            telemetry.addData("Left Stick", "is Positive!");
        }
        telemetry.addData("Left Stick value", lefty);
}

}
