package chapter10;

public class Client {
    public static void main(String[] args) {
        RoadDisplay roadDisplay = new RoadDisplay();
        roadDisplay.draw();

        RoadDisplayWithLane roadDisplayWithLane = new RoadDisplayWithLane();
        roadDisplayWithLane.drawLane();
    }
}
