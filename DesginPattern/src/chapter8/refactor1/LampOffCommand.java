package chapter8.refactor1;

import chapter8.refactor.Lamp;

public class LampOffCommand implements Command{
    private Lamp lamp;

    public LampOffCommand(Lamp lamp){
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        lamp.turnOff();
    }
}
