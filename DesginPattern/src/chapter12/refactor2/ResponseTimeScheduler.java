package chapter12.refactor2;

import chapter12.Direction;

public class ResponseTimeScheduler implements ElevatorScheduler {

    private static ResponseTimeScheduler scheduler = null;

    private ResponseTimeScheduler(){}

    public static ResponseTimeScheduler getInstance(){
        if(scheduler==null){
            scheduler = new ResponseTimeScheduler();
        }
        return scheduler;
    }

    @Override
    public int select(ElevatorManager elevatorManager, int destination, Direction direction) {
        return 0;
    }
}
