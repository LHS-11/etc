package chapter11;

public abstract class Motor {

    private Door door;
    private MotorStatus motorStatus;

    public Motor(Door door){
        this.door = door;
        motorStatus = MotorStatus.STOPPED;
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    public void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

    public void move(){
        MotorStatus motorStatus = getMotorStatus();
        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        moveMotor();

    }

    protected abstract void moveMotor();
}
