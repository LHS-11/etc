package chapter8.refactor1;

import chapter8.refactor.Lamp;

public class MainRe {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        LampOnCommand lampOnCommand = new LampOnCommand(lamp);
        LampOffCommand lampOffCommand = new LampOffCommand(lamp);

        Button button = new Button(lampOnCommand);
        button.pressed();

        button.setCommand(lampOffCommand);
        button.pressed();
    }
}
