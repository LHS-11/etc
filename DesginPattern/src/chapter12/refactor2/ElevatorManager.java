package chapter12.refactor2;

import chapter12.Direction;
import chapter12.ElevatorController;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManager{

    private List<ElevatorController> controllers;

    private SchedulingStrategyID strategyID;

    public ElevatorManager(int controllerCount,SchedulingStrategyID strategyID){
        controllers = new ArrayList<>(controllerCount);
        for (int i = 0; i < controllerCount; i++) {
            ElevatorController controller = new ElevatorController(i);
            controllers.add(controller);
        }
        this.strategyID = strategyID;
    }

    public void setStrategyID(SchedulingStrategyID strategyID){
        this.strategyID = strategyID;
    }

    void requestElevator(int destination, Direction direction){
        ElevatorScheduler scheduler = SchedulerFactory.getInstance(strategyID);
        System.out.println(scheduler);
        int selectedElevator = scheduler.select(this, destination, direction);
        controllers.get(selectedElevator).gotoFloor(destination);

    }


}
