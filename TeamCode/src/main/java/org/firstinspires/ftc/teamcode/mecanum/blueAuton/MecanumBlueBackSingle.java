package org.firstinspires.ftc.teamcode.mecanum.blueAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by StephanieRamirez on 12/2/17.
 */
@Autonomous(name = "MecanumBlueBackSingle")
public class MecanumBlueBackSingle extends MecanumBlue {


    @Override
    public void driveToParkingZone() throws InterruptedException {
        //drive(ENCODER_ROTATION * 2);
        acceleration(ENCODER_ROTATION * 2);
        Slowdrive(-ENCODER_ROTATION, 1);

        driveSlow(250, 2, false);
        robot.relicPivot.autonUp();
        Thread.sleep(800);
        robot.relicPivot.autonDown();
        waitForMotors(2);

    }

    @Override
    public void glyphAllignment(RelicRecoveryVuMark vuMark, Telemetry telemetry) throws InterruptedException {
        if (vuMark == RelicRecoveryVuMark.LEFT || vuMark == RelicRecoveryVuMark.UNKNOWN) {
            strafeLeft(-975, 5, false);
            robot.elevatorStages.stage1Delivery();
            robot.elevatorStages.motor.setPower(.05);
            robot.elevatorStages.motor2.setPower(.05);
            waitForMotors(5);

            telemetry.log().add("Left", RelicRecoveryVuMark.LEFT);

        } else if (vuMark == RelicRecoveryVuMark.CENTER) {
            strafeLeft(-1900, 5, false);
            robot.elevatorStages.stage1Delivery();
            robot.elevatorStages.motor.setPower(.05);
            robot.elevatorStages.motor2.setPower(.05);
            waitForMotors(5);

            telemetry.log().add("Center", RelicRecoveryVuMark.CENTER);

        } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
            strafeLeft(-3250, 5, false); robot.elevatorStages.stage1Delivery();
            robot.elevatorStages.motor.setPower(.05);
            robot.elevatorStages.motor2.setPower(.05);
            waitForMotors(5);

            telemetry.log().add("Right", RelicRecoveryVuMark.RIGHT);

        }
        telemetry.update();

        glyphDeliveryBlue();

    }

}

