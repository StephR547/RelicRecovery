package org.firstinspires.ftc.teamcode.mecanum.redAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by StephanieRamirez on 12/8/17.
 */
@Autonomous (name = "MecanumRedFar")
public class MecanumRedFar extends MecanumRed {

    @Override
    public void driveToParkingZone() throws InterruptedException {
        drive(-ENCODER_ROTATION * 3);

    }

    @Override
    public void glyphAllignment(RelicRecoveryVuMark vuMark) throws InterruptedException {
        if (vuMark == RelicRecoveryVuMark.LEFT || vuMark == RelicRecoveryVuMark.UNKNOWN){
            rotateLeft(ENCODER_ROTATION * 6, 6);

        }else if (vuMark == RelicRecoveryVuMark.CENTER){
            rotateLeft(ENCODER_ROTATION * 6, 6);

        }else if (vuMark == RelicRecoveryVuMark.RIGHT) {
            rotateLeft(ENCODER_ROTATION * 6, 6);


        }

    }
}
