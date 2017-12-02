package org.firstinspires.ftc.teamcode.mecanum;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.glyph.BottomGlyphServo;
import org.firstinspires.ftc.teamcode.glyph.ElevatorStages;
import org.firstinspires.ftc.teamcode.glyph.GlyphHook;
import org.firstinspires.ftc.teamcode.glyph.TopGlyphServo;
import org.firstinspires.ftc.teamcode.sensors.IMU;

/**
 * Created by StephanieRamirez on 9/22/17.
 */

public class MecanumHardware {
    public DcMotor frontLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor backRightMotor = null;
    public ElevatorStages elevatorStages = null;
    public TopGlyphServo topServo = null;
    public BottomGlyphServo bottomServo = null;
    public GlyphHook hook = null;
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
        elevatorStages= new ElevatorStages(hwMap.dcMotor.get("elevatorMotor"));

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to zero power
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        elevatorStages.initialize();

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        initServos();
        initSensors();
    }

    public void initServos() {

        //Servos Define
        topServo = new TopGlyphServo(hwMap.servo.get("topServo"));
        bottomServo = new BottomGlyphServo(hwMap.servo.get("bottomServo"));
        hook = new GlyphHook(hwMap.servo.get("glyphHook"));

        //Jewel Servo
        jewelArm = hwMap.servo.get("jewelArm");

        //Servos Initialize
        topServo.stop();
        bottomServo.stop();
        hook.intialize();

        //Jewel servo Initialize
        jewelArm.setPosition(.9);

    }

    public void initSensors() {

        //Color sensor initialize
        colorSensor = hwMap.colorSensor.get("colorsensor");
        colorSensor.enableLed(false);
    }
}

