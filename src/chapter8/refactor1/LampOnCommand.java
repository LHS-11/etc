package chapter8.refactor1;

import chapter8.refactor.Lamp;

public class LampOnCommand implements Command{

    private Lamp theLamp;

    public LampOnCommand(Lamp lamp){
        theLamp = lamp;
    }

    @Override
    public void execute() {
        theLamp.turnOn();
    }
}
