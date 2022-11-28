package chapter8;

public class Button {
    private Lamp theLamp;

    public Button(Lamp lamp){
        this.theLamp = lamp;
    }

    public void pressed(){
        theLamp.turnOn();
    }
}
