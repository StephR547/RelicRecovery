package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by StephanieRamirez on 8/19/17.
 */

@TeleOp(name = "SwerveTeleop")
public class SwerveTeleop extends LinearOpMode {

    SwerveHardware robot = new SwerveHardware();

    @Override
    public void runOpMode() {

        robot.setTelemetry(telemetry);
        robot.init(hardwareMap);

        while (true) {
            robot.swerveDrive.drive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

        }
    }
}

