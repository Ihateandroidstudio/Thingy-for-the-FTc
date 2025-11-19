package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Two Wheel Outtake")
public class TwoWheelOuttake extends LinearOpMode {

    private DcMotor outtakeLeft;
    private DcMotor outtakeRight;

    // able to adjust the power just change the numbers
    private final double OUTTAKE_POWER = 0.8;
    private final double REVERSE_POWER = -0.8;

    @Override
    public void runOpMode() throws InterruptedException {

        outtakeLeft = hardwareMap.get(DcMotor.class, "outtakeLeft");
        outtakeRight = hardwareMap.get(DcMotor.class, "outtakeRight");

        // most of the time one wheel is mirrored, so reverse one motor
        outtakeRight.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addLine("Ready");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {

            // Right trigger →  does OUTTAKE
            if (gamepad1.right_trigger > 0.1) {
                outtakeLeft.setPower(OUTTAKE_POWER);
                outtakeRight.setPower(OUTTAKE_POWER);
            }

            // Left trigger → makes it reverse (if needed)
            else if (gamepad1.left_trigger > 0.1) {
                outtakeLeft.setPower(REVERSE_POWER);
                outtakeRight.setPower(REVERSE_POWER);
            }

            // Otherwise let go to stop
            else {
                outtakeLeft.setPower(0);
                outtakeRight.setPower(0);
            }

            telemetry.addData("Left Power", outtakeLeft.getPower());
            telemetry.addData("Right Power", outtakeRight.getPower());
            telemetry.update();
        }
    }
}
