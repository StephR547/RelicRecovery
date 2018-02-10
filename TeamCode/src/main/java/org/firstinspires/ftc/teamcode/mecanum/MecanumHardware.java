package org.firstinspires.ftc.teamcode.mecanum;


import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.balancingBoard.TiltServos;
import org.firstinspires.ftc.teamcode.glyph.ElevatorStages;
import org.firstinspires.ftc.teamcode.glyph.vacuum.VacuumLatch;
import org.firstinspires.ftc.teamcode.glyph.vacuum.VacuumValve;
import org.firstinspires.ftc.teamcode.relic.RelicClamp;
import org.firstinspires.ftc.teamcode.relic.RelicPivot;
import org.firstinspires.ftc.teamcode.sensors.IMU;

/**
 * Created by StephanieRamirez on 9/22/17.
 */

public class MecanumHardware {
    public DcMotor frontLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor backLeftMotor = null;
    public DcMotor backRightMotor = null;
    public DcMotor relicElevator = null;
    public ElevatorStages elevatorStages = null;

    public VacuumValve vacuumServo = null;
    public VacuumLatch vacuumLatch = null;
    public Servo jewelArm = null;
    public RelicClamp relicClamp = null;
    public RelicPivot relicPivot = null;
    public TiltServos tiltServos = null;


    public IMU imu;
    public ColorSensor colorSensorTop;
    public ColorSensor colorSensorBottom;


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
        elevatorStages = new ElevatorStages(hwMap.dcMotor.get("elevatorMotor"));
        relicElevator = hwMap.dcMotor.get("relicElevator");

        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        // Set all motors to zero power
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
        relicElevator.setPower(0);
        elevatorStages.initialize();


        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        relicElevator.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        initServos();
        initSensors();
    }

    public void initServos() {

        //Servos Define
        vacuumServo = new VacuumValve(hwMap.servo.get("vacuumServo"));
        vacuumLatch = new VacuumLatch(hwMap.servo.get("vacuumLatch"));
        jewelArm = hwMap.servo.get("jewelArm");
        relicClamp = new RelicClamp(hwMap.servo.get("relicClamp"));
        relicPivot = new RelicPivot(hwMap.servo.get("relicPivotLeft"), hwMap.servo.get("relicPivotRight"));
        tiltServos = new TiltServos(hwMap.servo.get("tiltLeft"), hwMap.servo.get("tiltRight"));


        //Servos Initialize
        vacuumServo.stop();
        vacuumLatch.intialize();
        jewelArm.setPosition(.010);
        relicClamp.close();
        relicPivot.initilize();
        tiltServos.stop();

    }

    public void initSensors() {

        //Color sensor initialize
        colorSensorTop = hwMap.colorSensor.get("colorSensorTop");
        colorSensorTop.setI2cAddress(I2cAddr.create8bit(0x3c));
        colorSensorTop.enableLed(true);

        colorSensorBottom = hwMap.colorSensor.get("colorSensorBottom");
        colorSensorBottom.setI2cAddress(I2cAddr.create8bit(0x3a));
        colorSensorBottom.enableLed(true);
    }
}

