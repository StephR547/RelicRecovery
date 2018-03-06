package org.firstinspires.ftc.teamcode.glyph.vacuum;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 2/10/18.
 */

public class DoubleVacuum {
    public Servo topValveServo;
    public Servo bottomValveServo;
    public DcMotor flipMotor;
    public Servo lockServo;
    public AnalogInput magnetSensor;


    public DoubleVacuum(Servo topValveServo, Servo bottomValveServo, DcMotor flipMotor, Servo lockServo, AnalogInput magnetSensor) {
        this.topValveServo = topValveServo;
        this.bottomValveServo = bottomValveServo;
        this.flipMotor = flipMotor;
        this.lockServo = lockServo;
        this.magnetSensor = magnetSensor;
    }

    public void release() {
        if (isFlipped()) {
            topValveServo.setPosition(.9);
        } else {
            bottomValveServo.setPosition(.9);
        }

    }

    public void releaseTheTopServo() throws InterruptedException {
        bottomValveServo.setPosition(.9);

        Thread.sleep(300);

        bottomValveServo.setPosition(.5);
    }

    public void close() {
        if (isFlipped()) {
            topValveServo.setPosition(.1);
        } else {
            bottomValveServo.setPosition(.1);
        }

    }

    public void stop() {
        topValveServo.setPosition(.5);
        bottomValveServo.setPosition(.5);
    }

    public void unlockAndFlip() {

        lockServo.setPosition(.5);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        if (isFlipped()) {
            flipMotor.setPower(-.40);

        } else {
            flipMotor.setPower(.40);

        }

    }

    public boolean isFlipped() {
        return magnetSensor.getVoltage() < 1;
    }

    public void stopFlipAndLock() {
        flipMotor.setPower(0);
        lockServo.setPosition(.72);
    }

    public void flipContinue() {

        lockServo.setPosition(.5);

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }
        if (isFlipped()) {
            flipMotor.setPower(-.30);

        } else {
            flipMotor.setPower(.30);
        }
    }
}

