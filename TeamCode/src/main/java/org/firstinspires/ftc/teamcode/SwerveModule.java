package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 8/26/17.
 */

class SwerveModule {
    private DcMotor motor;
    private Servo servo;

    public SwerveModule (DcMotor motor, Servo servo){
        this.motor = motor;
        this.servo = servo;

    }

    public void setMovement(double speed, double angle) {
        motor.setPower(speed);

        double servoPosition = degreesToServo(angle);
        servo.setPosition(servoPosition);
// TODO Servo code for angles greater than 90
    }

    private double degreesToServo(double degrees) {
        return (degrees + 90)/ 180;
    }


}
