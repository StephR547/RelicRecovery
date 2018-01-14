package org.firstinspires.ftc.teamcode.mecanum.redAuton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by StephanieRamirez on 12/2/17.
 */
@Autonomous(name = "MecanumRedBack")
public class MecanumRedBack extends MecanumRed {

    @Override
    public void driveToParkingZone() throws InterruptedException {
        // rotateLeft(4500, 4);
        acceleration(-2500);

    }

    @Override
    public void glyphAllignment(RelicRecoveryVuMark vuMark, Telemetry telemetry) throws InterruptedException {
        if (vuMark == RelicRecoveryVuMark.LEFT || vuMark == RelicRecoveryVuMark.UNKNOWN) {
            drive(-(ENCODER_ROTATION + 945));
            strafeRight(-800, 2);
            rotateLeft(ENCODER_ROTATION + 900, 3);
            drive(300, 1);

            telemetry.log().add("Left", RelicRecoveryVuMark.LEFT);


        } else if (vuMark == RelicRecoveryVuMark.CENTER) {
            drive(-ENCODER_ROTATION);
            strafeRight(-800, 2);
            rotateLeft(ENCODER_ROTATION + 900, 3);
            drive(300, 1);

            telemetry.log().add("Center", RelicRecoveryVuMark.CENTER);

        } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
            drive(-550, 1);
            strafeRight(-800, 2);
            rotateLeft(ENCODER_ROTATION + 900, 3);
            drive(300, 1);

            telemetry.log().add("Right", RelicRecoveryVuMark.RIGHT);


        }
        telemetry.update();
        glyphDeliveryRed();

    }


}
