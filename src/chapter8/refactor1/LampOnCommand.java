package chapter8.refactor1;

import chapter8.refactor.Lamp;

public class LampOnCommand implements Command {

    private Lamp lamp;

    public LampOnCommand(Lamp lamp){
        this.lamp = lamp;
    }
    @Override
    public void execute() {
        lamp.turnOn();

    }

}
