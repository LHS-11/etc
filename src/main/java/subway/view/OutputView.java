package subway.view;

import static subway.constants.View.*;

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

    public void printStationSuccess(){
        System.out.println(STATION_REGISTRATION_SUCCESS_MESSAGE.getMessage());
    }
}
