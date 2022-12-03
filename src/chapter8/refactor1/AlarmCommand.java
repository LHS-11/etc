package chapter8.refactor1;

import chapter8.refactor.Alarm;

public class AlarmCommand implements Command{

    private Alarm alarm;

    public AlarmCommand(Alarm alarm){
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.start();
    }
}
