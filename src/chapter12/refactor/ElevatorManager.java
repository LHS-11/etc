package chapter12.refactor;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager {

    private List<ElevatorController> controllers;
    private SchedulingStrategyID strategyID;

    public ElevatorManager(int controllerCount,SchedulingStrategyID strategyID){
        controllers = new ArrayList<>();
        for (int i = 0; i < controllerCount; i++) {
            ElevatorController controller = new ElevatorController(i);
            controllers.add(controller);
        }
        this.strategyID = strategyID;
    }

    void requestElevator(int destination, Direction direction){

        ElevatorScheduler scheduler = SchedulerFactory.getScheduler(strategyID);
        System.out.println(scheduler);
        int selectElevator= scheduler.selectElevator(this, destination, direction);
        controllers.get(selectElevator).gotoFloor(destination);
    }
}
