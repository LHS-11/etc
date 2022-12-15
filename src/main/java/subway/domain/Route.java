package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Route {

    private List<Station> stations = new ArrayList<>(2);

    private int distance;

    private int time;

    public List<Station> getStations() {
        return stations;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public Route(List<Station> stations, int distance, int time) {
        this.stations = stations;
        this.distance = distance;
        this.time = time;
    }
}
