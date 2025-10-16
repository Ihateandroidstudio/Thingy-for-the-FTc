package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem extends SubsystemBase {
    private Motor frontleft;
    private Motor frontright;
    private Motor backright;
    private Motor backleft;

    private String frontleftmotor = "frontleft";
    private String frontrightmotor = "frontleft";
    private String backrightmotor = "backright";
    private String backleftmotor = "backleft";


    public DriveSubsystem (HardwareMap hardwareMap){
        frontleft = new Motor(hardwareMap, frontleftmotor, Motor.GoBILDA.RPM_312);
        frontright = new Motor(hardwareMap, frontrightmotor, Motor.GoBILDA.RPM_312);
        backright = new Motor(hardwareMap, backrightmotor, Motor.GoBILDA.RPM_312);
        backleft = new Motor(hardwareMap, backleftmotor, Motor.GoBILDA.RPM_312);

        frontleft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        frontright.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backleft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backright.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        frontleft.resetEncoder();
        frontright.resetEncoder();
        backleft.resetEncoder();
        backright.resetEncoder();

        drive = new MecanumDrive(frontleft,frontright,backleft,backright);
    }
    public void drive(double forward, double strafe, double rotate){

        drive.driveRobotCentric(strafe, forward, rotate);
    }
}
