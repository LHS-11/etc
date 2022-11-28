package chapter7.refactor;

public class On implements State{

    private static On on = new On();
    private On(){}

    public static On getInstance(){
        return on;
    }

    @Override
    public void on_button_pushed(Light light) {
        System.out.println("반응 없음");
    }

    @Override
    public void off_button_pushed(Light light) {
        System.out.println("Light Off!");
        light.setState(Off.getInstance());
    }
}
