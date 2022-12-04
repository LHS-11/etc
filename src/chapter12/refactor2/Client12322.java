package chapter12.refactor2;

import chapter12.Direction;

public class Client12322 {
    public static void main(String[] args) {
        ElevatorManager emWithResponseTimerScheduler = new ElevatorManager(2, SchedulingStrategyID.RESPONSE_TIME);
        emWithResponseTimerScheduler.requestElevator(10, Direction.UP);
        ElevatorManager emWithThroughputScheduler = new ElevatorManager(2, SchedulingStrategyID.THROUGHPUT);
        emWithThroughputScheduler.requestElevator(10,Direction.UP);
        ElevatorManager emWithDynamicScheduler = new ElevatorManager(2, SchedulingStrategyID.DYNAMIC);
        emWithDynamicScheduler.requestElevator(10,Direction.UP);
    }
}
