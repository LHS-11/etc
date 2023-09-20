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

    public static Station findStation(Station station) {
        return stations.stream().filter(s -> s.isSameStation(station))
                .findAny()
                .get();
    }
    public static void validateDuplicatedStation(Station station){
        stations.stream().filter(s -> s.isSameStation(station))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] : 이미 존재하는 역입니다."));
    }

    public static void validatePresentStation(Station station){
        boolean found = isFound(station);
        if(found){
            return;
        }
        throw new IllegalArgumentException("[ERROR] : 존재하지 않는 역입니다.");
    }

    private static boolean isFound(Station station) {
        return stations.stream().anyMatch(s -> s.isSameStation(station));
    }

    private static boolean isSame(Station s1,Station s2){
        return s1.getName().equals(s2.getName());
    }

    public static void validateSameStation(Station s1,Station s2){
        if(isSame(s1,s2)){
            throw new IllegalArgumentException("[ERROR] : 출발역과 도착역이 동일합니다.");
        }
    }



}
