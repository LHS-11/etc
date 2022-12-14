package subway.view;

import static subway.constants.View.MAIN_VIEW_MESSAGE;
import static subway.constants.View.STATION_VIEW_MESSAGE;

public class OutputView {

    public void printMainView(){
        System.out.println(MAIN_VIEW_MESSAGE.getMessage());
    }

    public void printStationControlView(){
        System.out.println(STATION_VIEW_MESSAGE.getMessage());
    }

    public void printErrorMessage(String message){
        System.out.println(message);
    }
}
