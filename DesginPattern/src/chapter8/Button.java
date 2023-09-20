package chapter8;

public class Button {
    private Lamp theLamp;
    private Alarm theAlarm;

    public Button(Lamp lamp){
        this.theLamp = lamp;
    }

    public void pressed(){
        theLamp.turnOn();
    }
}
