package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 11/25/17.
 */
@TeleOp(name = "RevTest")
public class RevTest extends LinearOpMode {
    public Servo servo1 = null;

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        servo1 = hardwareMap.servo.get("servo");

        telemetry.log().add("servoPosition");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            servosControls();

        }
    }

    public void servosControls() {

        double servo = (gamepad1.left_stick_y);
        servo1.setPosition(servo);
    }
}




