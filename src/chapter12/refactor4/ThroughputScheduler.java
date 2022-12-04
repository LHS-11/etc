package chapter12.refactor4;

import chapter12.Direction;

public class ThroughputScheduler implements ElevatorScheduler{

    private static ThroughputScheduler scheduler = null;
    private ThroughputScheduler(){}

    public static ThroughputScheduler getInstance(){
        if(scheduler==null){
            scheduler = new ThroughputScheduler();
        }
        return scheduler;
    }


    @Override
    public int select(ElevatorManager elevatorManager, int destination, Direction direction) {
        return 0;
    }
}
