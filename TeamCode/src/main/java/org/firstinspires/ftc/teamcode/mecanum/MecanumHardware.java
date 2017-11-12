package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.sensors.IMU;

/**
 * Created by StephanieRamirez on 9/22/17.
 */

public class MecanumHardware {
    public DcMotor frontLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor backRightMotor = null;
    public DcMotor elevatorMotor = null;
    public Servo bottomLeftWheel = null;
    public Servo bottomRightWheel = null;
    public Servo bottomPusher = null;
    public Servo bottomPincher = null;
    public Servo topLeftWheel = null;
    public Servo topRightWheel = null;
    public Servo topPusher = null;
    public Servo topPincher = null;
    public Servo jewelArm = null;

    public IMU imu;
    public ColorSensor colorSensor;


    private HardwareMap hwMap = null;

    public MecanumHardware() {

    }

    public void init(HardwareMap ahwMap) {
        hwMap = ahwMap;
       // imu = new IMU(hwMap.get(BNO055IMU.class, "imu"));

        // Define and Initialize Motors
        frontLeftMotor = hwMap.dcMotor.get("frontLeftMotor");
        frontRightMotor = hwMap.dcMotor.get("frontRightMotor");
        backLeftMotor = hwMap.dcMotor.get("backLeftMotor");
        backRightMotor = hwMap.dcMotor.get("backRightMotor");
        elevatorMotor = hwMap.dcMotor.get("elevatorMotor");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to zero power
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        elevatorMotor.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        elevatorMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        initServos();
        initSensors();
    }
    public void initServos() {

        //Bottom servos Define
        bottomLeftWheel = hwMap.servo.get("bottomLeftWheel");
        bottomRightWheel = hwMap.servo.get("bottomRightWheel");
        bottomPusher = hwMap.servo.get("bottomPusher");
        bottomPincher = hwMap.servo.get("bottomPincher");

        //Top servos Define
        topLeftWheel = hwMap.servo.get("topLeftWheel");
        topRightWheel = hwMap.servo.get("topRightWheel");
        topPusher = hwMap.servo.get("topPusher");
        topPincher = hwMap.servo.get("topPincher");

        //Jewel Servo
        jewelArm = hwMap.servo.get("jewelArm");

        //Bottom servos Initialize
        bottomLeftWheel.setPosition(.5);
        bottomRightWheel.setPosition(.5);
        bottomPusher.setPosition(.5);
        bottomPincher.setPosition(.5);

        //Top servos Initialize
        topLeftWheel.setPosition(.5);
        topRightWheel.setPosition(.5);
        topPusher.setPosition(.5);
        topPincher.setPosition(.5);

        //Jewel servo Initialize
        jewelArm.setPosition(0);

    }
    public void initSensors() {

        //Color sensor initialize
        colorSensor = hwMap.colorSensor.get("colorsensor");
        colorSensor.enableLed(false);
    }
}

