package org.firstinspires.ftc.teamcode.mecanum.redAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by StephanieRamirez on 12/8/17.
 */
@Autonomous(name = "MecanumRedFront")
public class MecanumRedFront extends MecanumRed {
    public int desiredValue;
    public double correctionValue;

    @Override
    public void driveToParkingZone() throws InterruptedException {

        //drive(-ENCODER_ROTATION * 5);
        rotateLeftFast(-4700, 8);
        // rotateLeft(4700, 8);//4);
        drive(2800);
        //drive(800);
        strafeRight(500, 2);
        Slowdrive(-ENCODER_ROTATION, 1);
        drive(200);


    }

    @Override
    public void glyphAllignment(RelicRecoveryVuMark vuMark, Telemetry telemetry) throws InterruptedException {

        double currentDistance = robot.redRangeSensor.cmUltrasonic();
        telemetry.log().add("RangeSensorValue; " + currentDistance);
        telemetry.update();

        if (currentDistance > 61 || currentDistance < 8){
            currentDistance = 39;
        }

        if (vuMark == RelicRecoveryVuMark.LEFT || vuMark == RelicRecoveryVuMark.UNKNOWN) {
            desiredValue = 102;

            correctionValue = desiredValue - currentDistance;
            strafeRightSlow(cmToEncoderTics(correctionValue), 7);//4);

            telemetry.log().add("Left", RelicRecoveryVuMark.LEFT);

        } else if (vuMark == RelicRecoveryVuMark.CENTER) {
            desiredValue = 74;

            correctionValue = desiredValue - currentDistance;
            strafeRightSlow(cmToEncoderTics(correctionValue), 7);
            // drive(200);

            telemetry.log().add("Center", RelicRecoveryVuMark.CENTER);

        } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
            desiredValue = 54;
            correctionValue = desiredValue - currentDistance;
            strafeRightSlow(cmToEncoderTics(correctionValue), 7);

            telemetry.log().add("Right", RelicRecoveryVuMark.RIGHT);


        }
        telemetry.log().add("CorrectionValue; " + correctionValue);
        telemetry.update();

        glyphDeliveryRed();

    }
}
