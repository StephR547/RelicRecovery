package org.firstinspires.ftc.teamcode.glyph;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by StephanieRamirez on 12/1/17.
 */

public class ElevatorStages {
    public DcMotor motor;
    public DcMotor motor2;

    final int STAGE_1_DELIVERY = 1500;
    final int STAGE_2_DELIVERY = 3500;
    final int STAGE_3_DELIVERY = 15000;
    final int STAGE_4_DELIVERY = 19500;

    final int STAGE_1_PICK_UP = 6000;
    final int STAGE_2_PICK_UP = 10500;
    final int STAGE_3_PICK_UP = 15000;

    int elevatorPosition;
    boolean usingElevatorJoystick;

    public ElevatorStages(DcMotor motor, DcMotor motor2) {
        this.motor = motor;
        this.motor2 = motor2;

        motor.setDirection(DcMotor.Direction.REVERSE);
    }

    //Glyph Delivery
    public void stage1Delivery() throws InterruptedException {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_1_DELIVERY);
        motor2.setTargetPosition(STAGE_1_DELIVERY);
        setMotorPower(.50);
        Thread.sleep(1500);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        // setMotorPower(0);
    }

    public void stage2Delivery() throws InterruptedException {
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setTargetPosition(STAGE_2_DELIVERY);
        motor2.setTargetPosition(STAGE_2_DELIVERY);
        setMotorPower(.30);
        Thread.sleep(900);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //setMotorPower(0);
    }

    public void setMotorPower(double power) {
        motor.setPower(power);
        motor2.setPower(power);
    }

    public int getMotorPosition() {
        return (motor.getCurrentPosition() + motor2.getCurrentPosition()) / 2;
    }

    public void holdPosition() {
        motor.setPower(.05);
        motor2.setPower(.05);

    }

    public void initialize() {
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setPower(0);
        motor2.setPower(0);
    }

    public void manualcontrol(double power) {

        if (Math.abs(power) >= .3) {
            usingElevatorJoystick = true;
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            motor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            motor.setPower(power);
            motor2.setPower(power);
            elevatorPosition = motor.getCurrentPosition();
        } else if (usingElevatorJoystick) {
            usingElevatorJoystick = false;
            motor.setPower(.05);
            motor2.setPower(.05);
            // motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            // motor.setTargetPosition(elevatorPosition);
        }
    }
}
