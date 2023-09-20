package subway.domain;

import java.util.ArrayList;
import java.util.List;

import static subway.domain.Validator.*;

public class Line {
    private String name;

    private List<Station> stations;

    public Line(String name) {
        validateLine(name);
        this.name = name;
        stations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean isSameLine(Line other){
        return this.name.equals(other.getName());
    }

    public void validateLine(String name){
        validateNameSize(name);
    }

    public void addStation(Station station){
        stations.add(station);
    }

    public void addFinalStation(Station upStation,Station downStation){
        stations.add(upStation);
        stations.add(downStation);
    }

    public boolean isPresentStation(int index){
        return stations.get(index).equals(null);
    }

}
