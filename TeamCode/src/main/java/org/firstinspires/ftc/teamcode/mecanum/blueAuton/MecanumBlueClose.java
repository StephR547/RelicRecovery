package org.firstinspires.ftc.teamcode.mecanum.blueAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by StephanieRamirez on 12/2/17.
 */
@Autonomous(name = "MecanumBlueClose")
public class MecanumBlueClose extends MecanumBlue {


    @Override
    public void driveToParkingZone() throws InterruptedException {
        drive(ENCODER_ROTATION * 2);
    }

    @Override
    public void glyphAllignment(RelicRecoveryVuMark vuMark) throws InterruptedException {
        if (vuMark == RelicRecoveryVuMark.LEFT || vuMark == RelicRecoveryVuMark.UNKNOWN){
            strafeRight(-ENCODER_ROTATION + 800);

        }else if (vuMark == RelicRecoveryVuMark.CENTER){
            strafeRight(-ENCODER_ROTATION + 2000);

        }else if (vuMark == RelicRecoveryVuMark.RIGHT) {
            strafeRight(-ENCODER_ROTATION * 3);

        }

    }

}

