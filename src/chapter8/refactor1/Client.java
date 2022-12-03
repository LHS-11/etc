package chapter8.refactor1;

import chapter8.refactor.Lamp;

public class Client {
    public static void main(String[] args) {

        Lamp lamp = new Lamp();
        LampOnCommand lampOnCommand = new LampOnCommand(lamp);
        Button button = new Button(lampOnCommand);
        button.press();
        button.setCommand(new LampOffCommand(lamp));
        button.press();
    }
}
