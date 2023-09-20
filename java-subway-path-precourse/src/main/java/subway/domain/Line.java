package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;

    private List<Station> stations;

    public Line(String name) {
        this.name = name;
        stations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    // 추가 기능 구현
    public void addStation(Station station){
        stations.add(station);
    }

    public boolean isSameLine(Line other){
        return this.name.equals(other.name);
    }



}
