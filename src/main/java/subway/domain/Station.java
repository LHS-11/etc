package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String name;

    private List<Line> lines;
    public Station(String name) {
        this.name = name;
        lines = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean isSameStation(Station other){
        return this.name.equals(other.name);
    }

    public void addLine(Line line){
        lines.add(line);
    }



}
