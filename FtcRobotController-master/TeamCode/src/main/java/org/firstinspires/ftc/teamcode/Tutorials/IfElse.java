package org.firstinspires.ftc.teamcode.Tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "More buttons being used")
public class IfElse extends OpMode {

    @Override
    public void init() {
        telemetry.addData("init", "Completed");
        telemetry.update();
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            telemetry.addData("a", "Pressed");
            // if the a button is being pressed it will print "a:Pressed

        } else if (gamepad1.b) {
            telemetry.addData("b", "Pressed");
            // if the b button is being pressed it will print "b:Pressed


        } else if (gamepad1.x) {
            telemetry.addData("x", "Pressed");
            // if the x button is being pressed it will print "x:Pressed


        } else if (gamepad1.y) {
            telemetry.addData("y", "Pressed");
            // if the y button is being pressed it will print "y:Pressed


        } else {
            telemetry.addData("No button", "Pressed");
            // if no button is being pressed it will print "No button:Pressed
        }
        telemetry.update();
        // updates the telemetry to show whats being pressed
        // if you want to add more buttons you can just add more else if statements like triggers and bumpers
        // will only print one line on the telemetry if more than one button is being pressed
        // it will prioritize whats first, so if button "A" is pressed it will skip over and not care about the other if statements
        // joysticks work differently because they will give 2 values that are numbers in the respective x any y directions

    }
}
