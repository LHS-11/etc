package chapter12.refactor2;

import chapter12.Direction;

public interface ElevatorScheduler {

    public int select(ElevatorManager elevatorManager, int destination, Direction direction);
}
