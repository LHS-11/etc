package chapter12.refactor4;

public class EMWithThroughputTimeScheduling extends ElevatorManager{

    public EMWithThroughputTimeScheduling(int controllerCount) {
        super(controllerCount);
    }

    @Override
    protected ElevatorScheduler getScheduler() {
        return ThroughputScheduler.getInstance();
    }
}
