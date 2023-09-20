package chapter7.refactor2;

public class Client {
    public static void main(String[] args) {

        Light light = new Light();
        light.on_button_pushed();
        light.off_button_pushed();
        light.off_button_pushed();
    }
}
