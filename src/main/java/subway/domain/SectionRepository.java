package subway.domain;

public class SectionRepository {

    public static void addSection(Line line,Station station){
        Line foundLine = LineRepository.findLine(line);
        foundLine.addStation(station);
        Station foundStation = StationRepository.findStation(station);
        foundStation.addLine(line);
    }
}
