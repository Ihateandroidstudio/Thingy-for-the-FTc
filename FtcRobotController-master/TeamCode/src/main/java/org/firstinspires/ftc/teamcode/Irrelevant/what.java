package org.firstinspires.ftc.teamcode.Irrelevant;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp(name = "what")
public class what extends OpMode {
    int uselessCounter = 0;

    @Override
    public void init() {
        telemetry.addData("hello", "I am Useless");
        telemetry.update();
    }

    @Override
    public void loop() {
        telemetry.addData("hello", "I am Useless but in a loop");
        uselessCounter++;
        telemetry.addData("uselessCounter", uselessCounter);
        telemetry.update();





    }
}
