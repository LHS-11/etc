package chapter8.refactor;

public class Client {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Alarm alarm = new Alarm();
        Button button = new Button(lamp, alarm);
        button.setTheMode(Mode.LAMP);
        button.pressed();
        button.setTheMode(Mode.ALARM);
        button.pressed();
    }
}
