package chapter12.refactor1;

import chapter12.Direction;
import chapter12.refactor1.ElevatorManager;

public interface ElevatorScheduler {

    public int select(ElevatorManager elevatorManager, int destination, Direction direction);
}
