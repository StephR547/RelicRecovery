package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 8/26/17.
 */

class SwerveModule {
    DcMotor motor;
    Servo servo;

    public void setMovement(float speed, float angle) {
        motor.setPower(speed);

        float servoPosition = degreesToServo(angle);
        servo.setPosition(servoPosition);
// TODO Servo code for angles greater than 90
    }

    private float degreesToServo(float degrees) {
        return (degrees + 90)/ 180;
    }


}
