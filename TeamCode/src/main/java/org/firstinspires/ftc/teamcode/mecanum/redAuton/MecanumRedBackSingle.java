package org.firstinspires.ftc.teamcode.mecanum.redAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by StephanieRamirez on 3/1/18.
 */
@Autonomous(name = "MecanumRedBackSingle")
public class MecanumRedBackSingle extends MecanumRed {
    @Override
    public void driveToParkingZone() throws InterruptedException {
        rotateLeft(-2350, 8, RotateSpeed.SLOW, true);
        driveSlow(3400);

        rotateLeft(-2350, 8, RotateSpeed.SLOW, false);
        robot.elevatorStages.stage1Delivery();
        robot.elevatorStages.motor.setPower(.05);
        robot.elevatorStages.motor2.setPower(.05);
        waitForMotors(8);

        driveSlow(2550, 7, false);
        robot.relicPivot.autonUp();
        Thread.sleep(800);
        robot.relicPivot.autonDown();
        waitForMotors(7);



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
            strafeLeft(-1550);
            drive(-300);

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

        glyphDeliveryRedFront();

    }
}

