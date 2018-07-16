package org.firstinspires.ftc.teamcode.mecanum.redAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by StephanieRamirez on 7/10/18.
 */

@Autonomous(name = "RedBackDoubleTest")
public class RedBackDoubleTest extends MecanumRed {
    @Override
    public void driveToParkingZone() throws InterruptedException {
        rotateLeft(-2350, 8, RotateSpeed.SLOW, false);
        robot.elevatorStages.stage1Delivery();
        robot.elevatorStages.motor.setPower(.05);
        robot.elevatorStages.motor2.setPower(.05);
        Thread.sleep(900);
        robot.tiltServos.lower();
        robot.tiltServos.servosIntake(0);
        waitForMotors(8);
        //driveSlow(3400, 8, false);
        acceleration(3200);


        rotateLeft(1500, 6, RotateSpeed.FAST, true);

        drive(1000);

        rotateLeft(-3850, 8, RotateSpeed.FAST, true);
//        robot.elevatorStages.stage1Delivery();
//        robot.elevatorStages.motor.setPower(.05);
//        robot.elevatorStages.motor2.setPower(.05);
//        waitForMotors(8);

       // drive(3550);


       /* drive(-2800);

        rotateLeft(4700, 8, RotateSpeed.FAST, true);
        robot.elevatorStages.stage1Delivery();
        robot.elevatorStages.motor.setPower(.05);
        robot.elevatorStages.motor2.setPower(.05);
        waitForMotors(8);

        Slowdrive(-700, 2);
        drive(200, 1);*/

    }

    @Override
    public void glyphAllignment(RelicRecoveryVuMark vuMark, Telemetry telemetry) throws InterruptedException {
        if (vuMark == RelicRecoveryVuMark.LEFT || vuMark == RelicRecoveryVuMark.UNKNOWN) {
            //strafeLeft(-2300, 5, false);
            rotateLeft(-550, 5, RotateSpeed.FAST, false);
            Thread.sleep(1000);
            robot.tiltServos.serovsIntakeStop();
            robot.tiltServos.retract();
            waitForMotors(5);

            drive(3600);

           // drive(-300);

            telemetry.log().add("Left", RelicRecoveryVuMark.LEFT);

        } else if (vuMark == RelicRecoveryVuMark.CENTER) {
            strafeLeft(-2650);
            drive(-300);


            telemetry.log().add("Center", RelicRecoveryVuMark.CENTER);

        } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
            strafeLeft(-3750);
            drive(-300);

            telemetry.log().add("Right", RelicRecoveryVuMark.RIGHT);

        }
        telemetry.update();

        DoubleGlyphDeliveryRedFront();

    }
}

