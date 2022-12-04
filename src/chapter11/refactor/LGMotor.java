package chapter11.refactor;

import chapter11.Direction;
import chapter11.Door;
import chapter11.DoorStatus;
import chapter11.MotorStatus;

public class LGMotor extends Motor{
    public LGMotor(Door door) {
        super(door);
    }

    @Override
    protected void moveMotor(Direction direction) {

    }


}
