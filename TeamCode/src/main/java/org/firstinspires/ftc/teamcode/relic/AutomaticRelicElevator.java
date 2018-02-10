package org.firstinspires.ftc.teamcode.relic;

import org.firstinspires.ftc.teamcode.mecanum.MecanumHardware;

/**
 * Created by StephanieRamirez on 2/3/18.
 */

public class AutomaticRelicElevator {
    public MecanumHardware robot;

    RelicElevatorStates currentStates = RelicElevatorStates.START;

    enum RelicElevatorStates {

        START,
        EXTENDING_ELEVATOR,
        PIVOTING_RELIC_DOWN,
        OPEN_CLAMP,
        CLEAR_RELIC,
        PIVOT_RELIC_UP,
        RETRACT_ELEVATOR,
        DONE,

    }

    public AutomaticRelicElevator(MecanumHardware robot) {
        this.robot = robot;
    }

   /* public boolean execute() {

        switch (currentStates) {
            case START:
                robot.relicElevator.setTargetPosition(10000);
                currentStates = RelicElevatorStates.EXTENDING_ELEVATOR;
                break;
            case EXTENDING_ELEVATOR:
                if (elevatorIsFullyExtended()) {
                    pivotRelicDown();
                    currentStates = RelicElevatorStates.PIVOTING_RELIC_DOWN;
                }
                break;
            case PIVOTING_RELIC_DOWN:
                if (relicPivoedDown()) {

                }
        }

    }
    public boolean elevatorIsFullyExtended() {

    }*/
}
