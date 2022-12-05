package chapter7.refactor2;

public class OFF implements State{

    private static OFF off=null;
    private OFF(){}
    public static OFF getInstance(){
        if(off==null){
            off = new OFF();
        }
        return off;
    }

    @Override
    public void on_button_pushed(Light light) {
        light.setState(ON.getInstance());
        System.out.println("Light ON!");
    }

    @Override
    public void off_button_pushed(Light light) {
        System.out.println("반응 없음");
    }
}
