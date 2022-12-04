package chapter12.refactor1;

import chapter12.Direction;
import chapter12.ElevatorController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ElevatorManager {

    private List<ElevatorController> controllers;

    private ElevatorScheduler scheduler;

    public ElevatorManager(int controllerCount){
        controllers = new ArrayList<>(controllerCount);
        for (int i = 0; i < controllerCount; i++) {
            ElevatorController controller = new ElevatorController(i);
            controllers.add(controller);
        }
    }

    void requestElevator(int destination, Direction direction){

        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if(hour<12){
            scheduler = new ResponseTimeScheduler();
        }else{
            scheduler = new ThroughputScheduler();
        }

        int selectedElevator = scheduler.select(this, destination, direction);
        controllers.get(selectedElevator).gotoFloor(destination);
    }
}
