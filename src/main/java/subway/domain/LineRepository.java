package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public void addStationToLine(Line line,Station station){
        Line foundLine = findLine(line);
        foundLine.addStation(station);
    }

    private static Line findLine(Line line) {
        return lines.stream().filter(l -> l.isSameLine(line))
                .findAny()
                .get();
    }

    public void validateDuplicatedLine(Line line){
        lines.stream().filter(s -> s.isSameLine(line))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] : 이미 존재하는 노선입니다."));
    }

    public void validatePresentSameLine(Line line, Station station){
        Line foundLine = findLine(line);
        if(isPresentStationSameLine(station, foundLine)){
            throw new IllegalArgumentException("[ERROR] : 같은 노선에 같은 역이 존재합니다");
        }

    }

    private static boolean isPresentStationSameLine(Station station, Line foundLine) {
        return foundLine.getStations().stream().anyMatch(s -> s.isSameStation(station));
    }

}
