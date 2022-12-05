package chapter7.refactor2;

public class ON implements State{

    private static ON on = null;
    private ON(){}
    public static ON getInstance(){
        if(on==null){
            on = new ON();
        }
        return on;
    }

    @Override
    public void on_button_pushed(Light light) {
        System.out.println("반응 없음");
    }

    @Override
    public void off_button_pushed(Light light) {
        light.setState(OFF.getInstance());
        System.out.println("Light OFF!");
    }
}
