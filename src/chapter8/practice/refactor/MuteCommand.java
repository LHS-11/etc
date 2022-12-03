package chapter8.practice.refactor;

import chapter8.practice.TV;

public class MuteCommand implements Command{

    private TV tv;

    public MuteCommand(TV tv){
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.mute();
    }
}
