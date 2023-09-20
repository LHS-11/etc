package chapter12.refactor4;

import chapter12.Direction;
import chapter12.ElevatorController;

import java.util.ArrayList;
import java.util.List;

public abstract class ElevatorManager {

    private List<ElevatorController> controllers;

    public ElevatorManager(int controllerCount){
        controllers = new ArrayList<>(controllerCount);
        for (int i = 0; i < controllerCount; i++) {
            ElevatorController controller = new ElevatorController(i);
            controllers.add(controller);
        }
    }

    protected abstract ElevatorScheduler getScheduler();

    public void requestElevator(int destination, Direction direction){

        ElevatorScheduler scheduler = getScheduler();
        int selectedElevator = scheduler.select(this, destination, direction);
        controllers.get(selectedElevator).gotoFloor(destination);
    }
}
