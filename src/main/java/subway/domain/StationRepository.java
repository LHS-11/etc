package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static subway.constants.ErrorMessage.*;

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

    public static void validateDuplicatedStation(Station station){
        if(isPresentStation(station)){
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR_MESSAGE.getMessage());
        }
    }
    public static void validatePresentStation(Station station){
        if(!isPresentStation(station)){
            throw new IllegalArgumentException(NON_PRESENT_ERROR_MESSAGE.getMessage());
        }
    }
    private static boolean isPresentStation(Station station) {
        return stations.stream().anyMatch(s -> s.isSameStation(station));
    }

    public static void validateStationPresentLine(Station station){
        if(isPresentLine(station)) {
            throw new IllegalArgumentException(PRESENT_LINE_ERROR_MESSAGE.getMessage());
        }
    }

    private static boolean isPresentLine(Station station){
        return stations.stream().filter(s->s.isSameStation(station))
                .anyMatch(s->s.isStationPresentLine());
    }

    public static void addLineToStation(Station station, Line line){
        Station foundStation = stations.stream()
                .filter(s -> s.isSameStation(station))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException("[ERROR] : 지하철 역이 존재하지 않습니다."));
        foundStation.addLine(line);
    }

}
