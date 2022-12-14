package subway.domain;

import java.util.List;

import static subway.domain.Validator.*;

public class Line {
    private String name;

    private List<Station> stations;

    public Line(String name) {
        validateLine(name);
        this.name = name;
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

}
