package chapter8.refactor1;

import chapter8.refactor.Lamp;

public class LampCommand implements Command{

    private Lamp lamp;

    public LampCommand(Lamp lamp){
        this.lamp = lamp;
    }
    @Override
    public void execute() {
        lamp.turnOn();
    }
}
