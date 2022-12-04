package chapter12.refactor;

public class ThroughputScheduler implements ElevatorScheduler {

    private static ElevatorScheduler scheduler;

    public static ElevatorScheduler  getInstance(){
        if(scheduler==null){
            scheduler = new ThroughputScheduler();
        }
        return scheduler;
    }



    public int selectElevator(ElevatorManager elevatorManager, int destination, Direction direction) {

        return 0;
    }
}
