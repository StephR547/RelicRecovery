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

    public SwerveModule(DcMotor motor, Servo servo, Telemetry telemetry){
        this.motor = motor;
        this.servo = servo;
        this.telemetry = telemetry;

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
