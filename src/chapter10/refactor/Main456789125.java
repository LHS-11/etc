package chapter10.refactor;

public class Main456789125 {

    public static void main(String[] args) {


        RoadDisplay roadDisplay = new RoadDisplay();
        roadDisplay.draw();
        System.out.println();
        LaneDecorator laneDecorator = new LaneDecorator(roadDisplay);
        laneDecorator.draw();
        System.out.println();
        TrafficDecorator trafficDecorator = new TrafficDecorator(laneDecorator);
        trafficDecorator.draw();


    }
}
