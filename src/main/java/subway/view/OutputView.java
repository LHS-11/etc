package subway.view;

import subway.domain.Station;

import java.util.List;

import static subway.constants.View.*;
import static subway.domain.StationRepository.deleteStation;
import static subway.domain.StationRepository.validatePresentStation;

public class OutputView {

    private static final String INFO = "[INFO]";

    public void printMainView(){
        System.out.println(MAIN_VIEW_MESSAGE.getMessage());
    }

    public void printStationControlView(){
        System.out.println(STATION_VIEW_MESSAGE.getMessage());
    }

    public void printErrorMessage(String message){
        System.out.println(message);
    }

    public void printStationSuccess(){
        System.out.println(STATION_REGISTRATION_SUCCESS_MESSAGE.getMessage());
    }

    public void printStationInfo(List<Station> stations){
        printStationList();
        stations.stream().map(s->s.getName()).forEach(name-> System.out.println(INFO+" "+name));
    }

    public void printStationList(){
        System.out.println(STATION_LIST_MESSAGE);
    }
}
