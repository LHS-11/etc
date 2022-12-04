package chapter11.refactor;

import chapter11.Direction;
import chapter11.Door;
import chapter11.DoorStatus;
import chapter11.MotorStatus;

public abstract class Motor {

    protected Door door;
    private MotorStatus motorStatus;

    public Motor(Door door){
        this.door = door;
        motorStatus = MotorStatus.STOPPED;
    }

    public MotorStatus getMotorStatus(){
        return motorStatus;
    }

    public void setMotorStatus(MotorStatus motorStatus){
        this.motorStatus = motorStatus;
    }

    public void move(Direction direction){ // 템플릿 메서드
        MotorStatus motorStatus = getMotorStatus();
        if(motorStatus==MotorStatus.MOVING){
            return;
        }

        DoorStatus doorStatus = door.getDoorStatus();
        if(doorStatus==DoorStatus.OPENED){
            door.close();
        }
        moveMotor(direction);
        setMotorStatus(MotorStatus.MOVING);
    }

    public abstract void moveMotor(Direction direction); // Primitive 메서드, hook 메서드


}
