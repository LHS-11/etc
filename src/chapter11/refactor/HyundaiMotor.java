package chapter11.refactor;

import chapter11.Direction;
import chapter11.Door;
import chapter11.DoorStatus;
import chapter11.MotorStatus;

public class HyundaiMotor extends Motor{
    public HyundaiMotor(Door door) {
        super(door);
    }

    @Override
    public void moveMotor(Direction direction) {

    }
}
