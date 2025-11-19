package org.firstinspires.ftc.teamcode.Irrelevant.mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled

public class TestBenchServo {
    private Servo servoPos;
    private CRServo servoRot;


    public void init(HardwareMap hwMap){
        servoPos = hwMap.get(Servo.class,"posservo");
        servoRot = hwMap.get(CRServo.class,"contservo");
        servoPos.scaleRange(0.5,1.0); //set range from midpoint to 180 degrees
        servoPos.setDirection(Servo.Direction.REVERSE);
        servoRot.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setServoPos(double angle) {
        servoPos.setPosition(angle);
    }

    public void setServoRot(double power) {
        servoRot.setPower(power);
    }
}
