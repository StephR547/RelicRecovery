package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 8/19/17.
 */

public class SwerveHardware {

    HardwareMap hwMap = null;

    public SwerveDrive swerveDrive = null;

    public SwerveHardware() {

    }

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;

        // Define and Initialize Motors
        DcMotor frontLeftMotor = hwMap.dcMotor.get("frontLeftMotor");
        DcMotor frontRightMotor = hwMap.dcMotor.get("frontRightMotor");
        DcMotor backLeftMotor = hwMap.dcMotor.get("backLeftMotor");
        DcMotor backRightMotor = hwMap.dcMotor.get("backRightMotor");

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
        Servo frontLeftServo = hwMap.servo.get("frontLeftServo");
        Servo frontRightServo = hwMap.servo.get("frontRightServo");
        Servo backLeftServo = hwMap.servo.get("backLeftServo");
        Servo backRightServo = hwMap.servo.get("backRightServo");

        frontLeftServo.setPosition(.5);
        frontRightServo.setPosition(.5);
        backLeftServo.setPosition(.5);
        backRightServo.setPosition(.5);

        SwerveModule frontLeft = new SwerveModule(frontLeftMotor, frontLeftServo);
        SwerveModule frontRight = new SwerveModule(frontRightMotor, frontRightServo);
        SwerveModule backLeft = new SwerveModule(backLeftMotor, backLeftServo);
        SwerveModule backRight = new SwerveModule(backRightMotor, backRightServo);

        swerveDrive = new SwerveDrive(frontLeft, frontRight, backLeft, backRight);
    }

}




