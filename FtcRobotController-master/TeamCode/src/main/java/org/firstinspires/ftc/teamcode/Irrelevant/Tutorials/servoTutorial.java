package org.firstinspires.ftc.teamcode.Irrelevant.Tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name = "servoTutorial")

public class servoTutorial extends OpMode {

    public Servo servo;
    // this creates a servo object
    // the might look kinda confusing because servo is written twice
    // the first servo is the action of actually creating a servo, if you want to create a servo, it must be public Servo (name)
    // the second servo is the name of the servo which in this case is "servo" but it can be name something else like "steeringServo" or "launcherServo"
    // this name doesn't have to match the name in the driver hub configuration.

    @Override
    public void init() {
        servo = hardwareMap.get(Servo.class, "servo");
        // hardwareMap is what connects the program to the machine
        // in simpler terms the first servo is the programming servo and the second servo is the real life servo
        // the servo that is surrounded by quotation marks has to match the name in your driver hub configuration
        // this line of code basically just says that when the programming servo is used, the real life servo corresponds to it


        //servos position values come up as 0.0-1.0
        //so a possible rotational position of a servo could be 0.4 or 0.23 but it something like 1.23 or -0.52 because it is not in the scope of 0.0-1.0

        servo.setPosition(0.0);
        // this sets the position of the servo to 0.0
        // you can change this value to whatever you want but it must be between 0.0 and 1.0
        // this line just sets what position you want the servo to be when you run the OpMode/Program
        // im pretty sure servos are only float values,
        // float numbers are numbers that are decimals

        telemetry.addData("Servo Position", servo.getPosition());
        telemetry.update();
        // this line of code just prints the position of the servo to the driver hub
        // this should print as "Servo Position: 0.0" because we set it to 0.0 previously


    }

    @Override
    public void loop() {

        if (gamepad1.a) {
            servo.setPosition(0.5);
            // if the a button is pressed on gamepad1, the servo will move to 0.5

            telemetry.addData("Servo A Position", servo.getPosition());
            // should print "Servo A Position: 0.5" to telemetry
            telemetry.update();
            // this is an example of how to use a button to control a servo

            // one problem with this is that the servo will only go to 0.5 when the A button is pressed and won't stay there if we let go
            // this might be a problem depending on what you are using the servo for, this wont be a problem for steering because you don't want the vehicle to be still turning after you have let go of the joystick/button
            // but this might be a problem for something like a launcher because you want the launcher to stay at a certain position after you have let go of the button



        } else {
            servo.setPosition(1.0);
            //sets the servo position to 1.0 when loop is running

            telemetry.addData("No Button Pressed Servo Position", servo.getPosition());
            telemetry.update();
            // this time it should print "Servo Position: 1.0" because we moved the servos position
        }



    }
}
