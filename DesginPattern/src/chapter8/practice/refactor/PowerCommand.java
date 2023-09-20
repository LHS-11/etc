package chapter8.practice.refactor;

import chapter8.practice.TV;

public class PowerCommand implements Command{

    private TV tv;

    public PowerCommand(TV tv){
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.power();
    }
}
