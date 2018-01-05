package org.firstinspires.ftc.teamcode.mecanum.redAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by StephanieRamirez on 12/2/17.
 */
@Autonomous(name = "MecanumRedClose")
public class MecanumRedClose extends MecanumRed {

    @Override
    public void driveToParkingZone() throws InterruptedException {
        drive(-ENCODER_ROTATION * 3);
        rotateLeft(2000);

    }

    @Override
    public void glyphAllignment(RelicRecoveryVuMark vuMark) throws InterruptedException {
        if (vuMark == RelicRecoveryVuMark.LEFT || vuMark == RelicRecoveryVuMark.UNKNOWN) {
            drive(-ENCODER_ROTATION - 800);
            rotateLeft(ENCODER_ROTATION * 4, 4);

        } else if (vuMark == RelicRecoveryVuMark.CENTER) {
            drive(-ENCODER_ROTATION - 300);
            rotateLeft(ENCODER_ROTATION * 4, 4);

        } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
            rotateLeft(ENCODER_ROTATION * 4, 4);


        }

    }


}
