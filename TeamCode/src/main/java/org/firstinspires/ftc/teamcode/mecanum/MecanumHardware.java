package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.BottomGlyphClamps;
import org.firstinspires.ftc.teamcode.glyph.TopGlyphClamp;
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
    public TopGlyphClamp topClamp = null;
    public BottomGlyphClamps bottomClamps = null;
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
        bottomClamps = new BottomGlyphClamps(hwMap.servo.get("bottomLeftClamp"),(hwMap.servo.get("bottomRightClamp")));

        //Top servos Define
        topClamp = new TopGlyphClamp(hwMap.servo.get("topClamp"));

        //Jewel Servo
        jewelArm = hwMap.servo.get("jewelArm");

        //Bottom servos Initialize
        bottomClamps.stop();

        //Top servos Initialize
        topClamp.stop();

        //Jewel servo Initialize
        jewelArm.setPosition(.9);

    }

    public void initSensors() {

        //Color sensor initialize
        colorSensor = hwMap.colorSensor.get("colorsensor");
        colorSensor.enableLed(false);
    }
}

