package org.firstinspires.ftc.teamcode.Irrelevant.Tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "motorEncoder")

public class MotorEncoder extends OpMode {
    public DcMotor testMotor;
    int targetTicks = 1000;
    // the number of ticks we want a motor to move

    @Override
    public void init() {
        testMotor = hardwareMap.get(DcMotor.class, "testMotor");
        testMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // motors can track "ticks" which are used to see how much a motor has rotated and also vice versa, to tell how much a motor to rotate
        // sets encoder / "tick" value to 0
        // resets the value

        telemetry.addData("Motor Encoder", "Reset");
        telemetry.update();
    }

    @Override
    public void loop() {
        testMotor.setTargetPosition(targetTicks);
        // tells the motor how much to move
        testMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        // tell the motor to move to the position
        testMotor.setPower(0.5);
        // sets the power to half speed

        telemetry.addData("Motor Ticks", testMotor.getCurrentPosition());
        telemetry.update();
        // prints the current "ticks" of the motor

    }

    // encoders are important for consistency, more for Autonomous(no human control)
    // less for TeleOp(Human Controller)

}
