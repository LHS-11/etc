package subway.domain;

public class Station {
    private String name;

    private Line line;
    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public boolean isSameStation(Station other){
        return this.name.equals(other.name);
    }

    public void addLine(Line line){
        this.line = line;
    }



}
