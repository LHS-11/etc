package subway.domain;

import static subway.domain.Validator.*;

public class Station {
    private String name;

    public Station(String name) {
        validateStation(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean isSame(Station other){
        return this.name == other.name;
    }

    public void validateStation(String name){
        validateNameSize(name);
    }

}
