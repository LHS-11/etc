package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Route {

    private List<Station> stations = new ArrayList<>(2);

    private int distance;

    private int time;

    public Route(List<Station> stations, int distance, int time) {
        this.stations = stations;
        this.distance = distance;
        this.time = time;
    }
    public List<Station> getStations() {
        return stations;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public boolean isSameRoute(List<String> other){
        return stations.stream().map(s->s.getName()).collect(Collectors.toList()).containsAll(other);
    }
}
