package chapter10.refactor;

public abstract class RoadDecorator extends Display{

    private Display display;

    public RoadDecorator(Display display){
        this.display = display;
    }

    public void draw(){
        display.draw();
    }

}
