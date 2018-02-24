package org.firstinspires.ftc.teamcode.relic;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.mecanum.MecanumHardware;

/**
 * Created by StephanieRamirez on 2/3/18.
 */

public class AutomaticRelicElevator {
    public MecanumHardware robot;

    RelicElevatorStates currentState = RelicElevatorStates.START;
    ElapsedTime timeKeeper;

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

        switch (currentState) {
            case START:
                robot.relicElevator.setTargetPosition(10000);
                currentState = RelicElevatorStates.EXTENDING_ELEVATOR;
                break;
            case EXTENDING_ELEVATOR:
                if (elevatorIsFullyExtended()) {
                    robot.relicPivot.down();
                    timeKeeper = new ElapsedTime();
                    currentState = RelicElevatorStates.PIVOTING_RELIC_DOWN;
                }
                break;
            case PIVOTING_RELIC_DOWN:
                if (timeKeeper.seconds() > 5) {
                    //stuff
                }
                break;
        }

    }
    public boolean elevatorIsFullyExtended() {

    } */
}
