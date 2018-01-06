package org.firstinspires.ftc.teamcode.glyph;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by StephanieRamirez on 12/1/17.
 */

public class ElevatorStages {
    public DcMotor motor;

    final int STAGE_1_DELIVERY = 1500;
    final int STAGE_2_DELIVERY = 10500;
    final int STAGE_3_DELIVERY = 15000;
    final int STAGE_4_DELIVERY = 19500;

    final int STAGE_1_PICK_UP = 6000;
    final int STAGE_2_PICK_UP = 10500;
    final int STAGE_3_PICK_UP = 15000;

    int elevatorPosition;
    boolean usingElevatorJoystick;

    public ElevatorStages(DcMotor motor) {
        this.motor = motor;
    }

    //Glyph Delivery
    public void stage1Delivery() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_1_DELIVERY);
        motor.setPower(.5);
    }

    public void stage2Delivery() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_2_DELIVERY);
        motor.setPower(.5);
    }

    public void stage3Delivery() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_3_DELIVERY);
        motor.setPower(.5);
    }

    public void stage4Delivery() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_4_DELIVERY);
        motor.setPower(.5);
    }

    //Glyph Pick Up
    public void stage0PickUp() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_1_PICK_UP);
        motor.setPower(.5);
    }

    public void stage1PickUp() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_2_PICK_UP);
        motor.setPower(.5);
    }

    public void stage2PickUp() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_3_PICK_UP);
        motor.setPower(.5);
    }

    public void initialize() {
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setPower(0);
    }

    public void manuelcontrol(double power) {

        if (Math.abs(power) >= .3) {
            usingElevatorJoystick = true;
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            motor.setPower(power);
            elevatorPosition = motor.getCurrentPosition();
        } else if (usingElevatorJoystick) {
            usingElevatorJoystick = false;
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor.setTargetPosition(elevatorPosition);
        }
    }
}
