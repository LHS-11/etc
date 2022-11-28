package chapter7.refactor;

public class Off implements State{

    private static Off off = new Off();

    private Off(){}

    public static Off getInstance(){
        return off;
    }
    @Override
    public void on_button_pushed(Light light) {
        System.out.println("Light On!!");
        light.setState(On.getInstance());
    }

    @Override
    public void off_button_pushed(Light light) {
        System.out.println("반응 없음");
    }
}
