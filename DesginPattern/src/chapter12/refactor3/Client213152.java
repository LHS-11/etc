package chapter12.refactor3;

import chapter12.Direction;

public class Client213152 {
    public static void main(String[] args) {

        ElevatorManagerWithResponseTimeScheduling scheduling = new ElevatorManagerWithResponseTimeScheduling(2);
        scheduling.requestElevator(2, Direction.UP);
        ElevatorManagerWithDynamicScheduling scheduling1 = new ElevatorManagerWithDynamicScheduling(2);
        scheduling1.requestElevator(2, Direction.DOWN);
    }
}
