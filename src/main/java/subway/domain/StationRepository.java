package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public void addLineToStation(Station station, Line line) {
        Station foundStation = findStation(station);
        foundStation.addLine(line);
    }

    public Station findStation(Station station) {
        return stations.stream().filter(s -> s.isSameStation(station))
                .findAny()
                .get();
    }
    public void validateDuplicatedStation(Station station){
        stations.stream().filter(s -> s.isSameStation(station))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] : 이미 존재하는 역입니다."));
    }

}
