package org.firstinspires.ftc.teamcode.balancingBoard;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by StephanieRamirez on 1/13/18.
 */

public class TiltServos {
    public Servo servoLeft;
    public Servo servoRight;
    public Servo tailHookServo;
    public Servo intakeLeft;
    public Servo intakeRight;


    boolean tiltArmsAreLowered = false;


    public TiltServos(Servo servoLeft, Servo servoRight, Servo tailHookServo, Servo intakeLeft, Servo intakeRight) {
        this.servoLeft = servoLeft;
        this.servoRight = servoRight;
        this.tailHookServo = tailHookServo;
        this.intakeLeft = intakeLeft;
        this.intakeRight = intakeRight;

    }
    public void tiltToggle() {
        if (tiltArmsAreLowered){
            retract();
        }else {
            lower();
        }
    }

    public void lower() {
        tiltArmsAreLowered = true;
        servoLeft.setPosition(0);
        servoRight.setPosition(1);
    }

    public void retract() {
        tiltArmsAreLowered = false;
        //Original .8
        servoLeft.setPosition(1);
        //Original .2
        servoRight.setPosition(0);
    }

    public void stop() {
        servoLeft.setPosition(.5);
        servoRight.setPosition(.5);
    }

    public void servosIntake(double rotateRight) {
        if (rotateRight > .2) {
            intakeLeft.setPosition(1);
            intakeRight.setPosition(1);
        } else if (rotateRight < -.2) {
            intakeLeft.setPosition(0);
            intakeRight.setPosition(0);
        } else {
            intakeLeft.setPosition(1);
            intakeRight.setPosition(0);
        }

    }

    public void servoOutake() {
        intakeLeft.setPosition(0);
        intakeRight.setPosition(1);
    }

    public void serovsIntakeStop() {
        intakeLeft.setPosition(.5);
        intakeRight.setPosition(.5);
    }

    public void initiliaze() {
        tailHookServo.setPosition(1);
    }

    public void intake() {
        servoRight.setPosition(1);
    }

    public void intakeStop () {
        servoRight.setPosition(.5);
    }
    public void tailHookLower(){
        tailHookServo.setPosition(0);

    }
    public void tailHookRetract() {
        tailHookServo.setPosition(1);
    }


}

