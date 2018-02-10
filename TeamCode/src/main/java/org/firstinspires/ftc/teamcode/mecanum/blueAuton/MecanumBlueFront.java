package org.firstinspires.ftc.teamcode.mecanum.blueAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by StephanieRamirez on 12/2/17.
 */
@Autonomous(name = "MecanumBlueFront")
public class MecanumBlueFront extends MecanumBlue {


    @Override
    public void driveToParkingZone() throws InterruptedException {
        drive(ENCODER_ROTATION * 2);
        Slowdrive(-ENCODER_ROTATION, 1);
        drive(250);
    }

    @Override
    public void glyphAllignment(RelicRecoveryVuMark vuMark, Telemetry telemetry) throws InterruptedException {
        if (vuMark == RelicRecoveryVuMark.LEFT || vuMark == RelicRecoveryVuMark.UNKNOWN) {
            strafeRight(-ENCODER_ROTATION / 2);

            telemetry.log().add("Left", RelicRecoveryVuMark.LEFT);

        } else if (vuMark == RelicRecoveryVuMark.CENTER) {
            strafeRight(-ENCODER_ROTATION - 500);

            telemetry.log().add("Center", RelicRecoveryVuMark.CENTER);

        } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
            strafeRight((-ENCODER_ROTATION - 150) * 2);

            telemetry.log().add("Right", RelicRecoveryVuMark.RIGHT);

        }
        telemetry.update();

        glyphDeliveryBlue();

    }

}

