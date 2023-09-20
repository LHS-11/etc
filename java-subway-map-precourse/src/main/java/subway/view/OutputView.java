package subway.view;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;

import static subway.constants.View.*;

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

    public void printStationRemoving(){
        System.out.println(STATION_REMOVING_SUCCESS_MESSAGE.getMessage());
    }

    public void printStationInfo(List<Station> stations){
        printStationList();
        stations.stream().map(s->s.getName()).forEach(name-> System.out.println(INFO+" "+name));
    }

    private static void printStationList(){
        System.out.println(STATION_LIST_MESSAGE.getMessage());
    }

    public void printLineControlView(){
        System.out.println(LINE_VIEW_MESSAGE.getMessage());
    }

    public void printLineInfo(List<Line> lines){
        printLineList();
        lines.stream().map(s->s.getName()).forEach(name-> System.out.println(INFO+" "+name));
    }

    private static void printLineList(){
        System.out.println(STATION_LIST_MESSAGE.getMessage());
    }

    public void printLineRemoving(){
        System.out.println(LINE_REMOVING_SUCCESS_MESSAGE.getMessage());
    }

    public void printUpBoundFinalStation(){
        System.out.println(REGISTER_UP_BOUND_STATION_MESSAGE.getMessage());
    }

    public void printDownBoundFinalStation(){
        System.out.println(REGISTER_DOWN_BOUND_STATION_MESSAGE.getMessage());
    }

    public void printStationRegistration(){
        System.out.println(REGISTER_STATION_MESSAGE.getMessage());
    }
}
