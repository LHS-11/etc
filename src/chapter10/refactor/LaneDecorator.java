package chapter10.refactor;

public class LaneDecorator extends DisplayDecorator {

    public LaneDecorator(Display display) {
        super(display);
    }

    public void draw(){
        super.draw();
    }

    public void drawLane(){
        System.out.print("\t 차선 표시");
    }
}
