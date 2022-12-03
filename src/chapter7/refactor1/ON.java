package chapter7.refactor1;

public class ON implements State{

    private static ON on = new ON();

    private ON(){};

    public static ON getInstance(){
        return on;
    }

    @Override
    public void on_button_pushed(Light light) {
        System.out.println("반응 없음");
    }

    @Override
    public void off_button_pushed(Light light) {
        light.setState(new OFF());
        System.out.println("Light OFF!");
    }
}
