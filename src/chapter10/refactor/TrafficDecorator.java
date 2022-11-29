package chapter10.refactor;

public class TrafficDecorator extends RoadDecorator{


    public TrafficDecorator(Display display) {
        super(display);
    }

    public void draw(){
        super.draw();
        drawTraffic();
    }

    public void drawTraffic(){
        System.out.println("\t교통량 표시");
    }
}
