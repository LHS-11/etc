package chapter8.refactor;


public class Button {
    private Lamp theLamp;
    private Alarm theAlarm;
    private Mode theMode;

    public Button(Lamp lamp, Alarm alarm){
        this.theLamp = lamp;
        this.theAlarm = alarm;
    }

    public void setTheMode(Mode theMode){
        this.theMode = theMode;
    }

    public void pressed(){
        switch (theMode){
            case LAMP:
                theLamp.turnOn();
                break;
            case ALARM:
                theAlarm.start();
                break;
        }
    }

}
