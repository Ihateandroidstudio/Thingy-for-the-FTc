package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Two Wheel Outake")
public class TwoWheelOutake extends LinearOpMode {

    private DcMotor outakeLeft;
    private DcMotor outakeRight;

    // able to adjust the power just change the numbers
    private final double OUTTAKE_POWER = 0.8;
    private final double REVERSE_POWER = -0.8;

    @Override
    public void runOpMode() throws InterruptedException {

        outakeLeft = hardwareMap.get(DcMotor.class, "outtakeLeft");
        outakeRight = hardwareMap.get(DcMotor.class, "outtakeRight");

        // most of the time one wheel is mirrored, so reverse one motor
        outakeRight.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addLine("Ready");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {

            // Right trigger →  does OUTTAKE
            if (gamepad1.right_trigger > 0.1) {
                outakeLeft.setPower(OUTTAKE_POWER);
                outakeRight.setPower(OUTTAKE_POWER);
            }

            // Left trigger → makes it reverse (if needed)
            else if (gamepad1.left_trigger > 0.1) {
                outakeLeft.setPower(REVERSE_POWER);
                outakeRight.setPower(REVERSE_POWER);
            }

            // Otherwise let go to stop
            else {
                outakeLeft.setPower(0);
                outakeRight.setPower(0);
            }

            telemetry.addData("Left Power", outakeLeft.getPower());
            telemetry.addData("Right Power", outakeRight.getPower());
            telemetry.update();
        }
    }
}
