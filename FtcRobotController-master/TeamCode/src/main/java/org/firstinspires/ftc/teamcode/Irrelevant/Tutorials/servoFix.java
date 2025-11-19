package org.firstinspires.ftc.teamcode.Irrelevant.Tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "ServoFix")

public class servoFix extends OpMode {

    public Servo servo;

    int servoCounter;
    // here we create a "int" variable and it "servoCounter"
    // int values are different from floats because they are only whole numbers, so no decimals allowed

    // why cant this be a "boolean"?
    // a boolean value can only be 2 values, True or False
    // we can use a boolean value if we wanted to but a int value is more flexible because we have more values that can create more if statements as shown below
    @Override
    public void init() {
        servo = hardwareMap.get(Servo.class, "servo");

        servoCounter = 0;
        // in this line we retrieve the previously created variable and set the value to 0 everytime it initializes

        servo.setPosition(0.0);

        telemetry.addData("Servo Position", servo.getPosition());
        telemetry.update();


    }

    @Override
    public void loop() {

        // sets a number to each button on the controller
        if (gamepad1.a) {
            servoCounter = 1;
            //sets "servoCounter" to one if button "A" is pressed
        }
        if (gamepad1.b) {
            servoCounter = 2;
        }
        if (gamepad1.x) {
            servoCounter = 3;
        }
        if (gamepad1.y) {
            servoCounter = 4;
        }

        if (servoCounter == 1) {
            //checks if Servo counter is equal to one
            //this is different from only one equal sign because one equal sign set a value of a variable
            //but two equal signs is a comparison and check if the value of a variable is equal to a certain value

            servo.setPosition(0.5);

            telemetry.addData("Servo A Position", servo.getPosition());
            telemetry.update();
        }

        // sets a servo value according to which number "servoCounter" is
        if (servoCounter == 2) {
            servo.setPosition(0.25);
            telemetry.addData("Servo B Position", servo.getPosition());
            telemetry.update();
            //this is the same as the previous if statement but instead it checks if the servoCounter is equal to 2 and sets the servo position to 0.25
            //it also prints it onto the telemetry as well
        }
        if (servoCounter == 3) {
            servo.setPosition(0.75);
            telemetry.addData("Servo X Position", servo.getPosition());
            telemetry.update();
        }
        if (servoCounter == 4) {
            servo.setPosition(1.0);
            telemetry.addData("Servo Y Position", servo.getPosition());
            telemetry.update();
        }
    }
}