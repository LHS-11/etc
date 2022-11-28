package chapter8.refactor1;

import chapter8.refactor.Alarm;
import chapter8.refactor.Lamp;

public class AlarmOnCommand implements Command{

    private Alarm theAlarm;

    public AlarmOnCommand(Alarm alarm){
        theAlarm = alarm;
    }
    @Override
    public void execute() {
        theAlarm.start();
    }
}
