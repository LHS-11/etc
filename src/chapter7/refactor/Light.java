package chapter7.refactor;

public class Light {

    private State state;

    public Light(){
        state = new Off();
    }

    public void setState(State state){
        this.state = state;
    }

    public void on_button_pushed(){
        state.on_button_pushed(this);
    }

    public void off_button_pushed(){
        state.off_button_pushed(this);
    }

}
