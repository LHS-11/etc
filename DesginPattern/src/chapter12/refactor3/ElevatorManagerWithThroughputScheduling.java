package chapter12.refactor3;

public class ElevatorManagerWithThroughputScheduling extends ElevatorManager{
    public ElevatorManagerWithThroughputScheduling(int controllerCount) {
        super(controllerCount);
    }

    @Override
    protected ElevatorScheduler getScheduler() {
        ThroughputScheduler scheduler = ThroughputScheduler.getInstance();
        return scheduler;
    }
}
