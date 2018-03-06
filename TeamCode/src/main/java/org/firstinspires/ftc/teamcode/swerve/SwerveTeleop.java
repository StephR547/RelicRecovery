package org.firstinspires.ftc.teamcode.swerve;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by StephanieRamirez on 8/19/17.
 */
@Disabled
@TeleOp(name = "SwerveTeleop")
public class SwerveTeleop extends LinearOpMode {

    SwerveHardware robot = new SwerveHardware();

    @Override
    public void runOpMode() {

        robot.setTelemetry(telemetry);
        robot.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            robot.swerveDrive.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x,robot.imu.getheading());

            telemetry.addData("heading", robot.imu.getheading());

            telemetry.update();

            idle();

        }
    }
}

