package subway.domain;

import static subway.domain.Validator.*;

public class Station {
    private String name;

    private Line line;

    public Station(String name) {
        validateStation(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean isSameStation(Station other){
        return this.name.equals(other.getName());
    }

    public void validateStation(String name){
        validateNameSize(name);
    }

    public boolean isStationPresentLine(){
        return line != null;
    }

    public void addLine(Line line){
        this.line = line;
    }

}
