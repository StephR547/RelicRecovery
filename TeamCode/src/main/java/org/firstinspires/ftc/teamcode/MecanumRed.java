package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by StephanieRamirez on 10/14/17.
 */
@Autonomous(name = "MecanumRed")
public class MecanumRed extends MecanumAuton {

    @Override
    public void runOpMode() throws InterruptedException {

        telemetry.log().add("about to int");
        telemetry.update();
        robot.init(hardwareMap);
        telemetry.log().add("waiting for start");
        telemetry.update();

        waitForStart();

        telemetry.log().add("starting");
        telemetry.update();

        robot.jewelArm.setPosition(.8);
        Thread.sleep(3000);

        int red = robot.colorSensor.red();
        int  blue = robot.colorSensor.blue();
        if (red > blue){
            telemetry.addData("STATE (R): ", "Red");
            drive(-1495 /3);
            drive(1495 /3);
        }else if (red < blue) {
            telemetry.addData("STATE (B): ", "Blue");
            drive(1495 /3);
            drive(-1495 /3);
        }

        robot.jewelArm.setPosition(0);
        Thread.sleep(3000);

           drive(1495 * 3);
        telemetry.update();

    }


}

