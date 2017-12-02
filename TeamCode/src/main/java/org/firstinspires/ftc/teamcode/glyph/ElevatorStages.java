package org.firstinspires.ftc.teamcode.glyph;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by StephanieRamirez on 12/1/17.
 */

public class ElevatorStages {
    public DcMotor motor;

    final int STAGE_1_DELIVERY = 100;
    final int STAGE_2_DELIVERY = 200;
    final int STAGE_3_DELIVERY = 300;
    final int STAGE_4_DELIVERY = 400;

    final int STAGE_1_PICK_UP = 0;
    final int STAGE_2_PICK_UP = 100;
    final int STAGE_3_PICK_UP = 200;

    int elevatorPosition;
    boolean usingElevatorJoystick;

    public ElevatorStages(DcMotor motor) {
        this.motor = motor;
    }

    //Glyph Delivery
    public void stage1Delivery() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_1_DELIVERY);
    }

    public void stage2Delivery() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_2_DELIVERY);
    }

    public void stage3Delivery() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_3_DELIVERY);
    }

    public void stage4Delivery() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_4_DELIVERY);
    }

    //Glyph Pick Up
    public void stage0PickUp() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_1_PICK_UP);
    }

    public void stage1PickUp() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_2_PICK_UP);
    }

    public void stage2PickUp() {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_3_PICK_UP);
    }

    public void initialize() {
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setPower(0);
    }

    public void manuelcontrol(double power) {

        if (power != 0) {
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
