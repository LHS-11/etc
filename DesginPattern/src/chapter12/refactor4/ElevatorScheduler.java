package chapter12.refactor4;

import chapter12.Direction;

public interface ElevatorScheduler {

    public int select(ElevatorManager elevatorManager, int destination, Direction direction);
}
