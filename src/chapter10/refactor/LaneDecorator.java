package chapter10.refactor;

public class LaneDecorator extends RoadDecorator{

    public LaneDecorator(Display display) {
        super(display);
    }

    public void draw(){
        super.draw();
        drawLane();
    }

    public void drawLane(){
        System.out.println("\t차선 표시");
    }
}
