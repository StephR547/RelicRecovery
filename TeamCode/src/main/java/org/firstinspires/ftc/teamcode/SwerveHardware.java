package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 8/19/17.
 */

public class SwerveHardware {

    public DcMotor frontLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor backRightMotor = null;

    public Servo frontLeftServo = null;
    public Servo frontRightServo = null;
    public Servo backLeftServo = null;
    public Servo backRightServo = null;

    HardwareMap hwMap = null;

    public SwerveHardware() {

    }

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        // Define and Initialize Motors
        frontLeftMotor = hwMap.dcMotor.get("frontLeftMotor");
        frontRightMotor = hwMap.dcMotor.get("frontRightMotor");
        backLeftMotor = hwMap.dcMotor.get("backLeftMotor");
        backRightMotor = hwMap.dcMotor.get("backRightMotor");

        // Set all motors to zero power
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //Define and Initialize Servos
        frontLeftServo = hwMap.servo.get("frontLeftServo");
        frontRightServo = hwMap.servo.get("frontRightServo");
        backLeftServo = hwMap.servo.get("backLeftServo");
        backRightServo = hwMap.servo.get("backRightServo");

        frontLeftServo.setPosition(.5);
        frontRightServo.setPosition(.5);
        backLeftServo.setPosition(.5);
        backRightServo.setPosition(.5);
    }

}




