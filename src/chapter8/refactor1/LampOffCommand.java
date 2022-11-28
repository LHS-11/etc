package chapter8.refactor1;

import chapter8.refactor.Lamp;

public class LampOffCommand implements Command{
    private Lamp theLamp;

    public LampOffCommand(Lamp lamp){
        this.theLamp = lamp;
    }

    public void execute(){
        theLamp.turnOff();
    }
}
