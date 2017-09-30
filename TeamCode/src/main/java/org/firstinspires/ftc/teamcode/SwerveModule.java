package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by StephanieRamirez on 8/26/17.
 */

class SwerveModule {
    private final Telemetry telemetry;
    private DcMotor motor;
    private Servo servo;

    public SwerveModule(DcMotor motor, Servo servo, Telemetry telemetry) {
        this.motor = motor;
        this.servo = servo;
        this.telemetry = telemetry;

    }

    public void stop() {
        motor.setPower(0);
    }

    public void setMovement(double speed, double angle) {
        if (angle > 90 || angle < -90) {
            reverse(speed, angle);
        } else {
            double servoPosition = degreesToServo(angle);
            servo.setPosition(servoPosition);
            motor.setPower(speed);
        }

    }

    private double degreesToServo(double degrees) {
        return (degrees + 90) / 180;
    }

    private double reverseAngle(double angle) {
        if (angle > 0) {
            return angle - 180;
        } else {
            return angle + 180;
        }
    }

    private void reverse(double speed, double angle) {
        motor.setPower(-speed);
        double reverseAngle = reverseAngle(angle);
        double servoPosition = degreesToServo(reverseAngle);
        servo.setPosition(servoPosition);
    }


}
