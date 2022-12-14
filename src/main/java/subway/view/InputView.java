package subway.view;

import camp.nextstep.edu.missionutils.Console;
import subway.constants.View;

import static subway.constants.View.*;

public class InputView {

    public String inputFunction(){
        System.out.println(FUNCTION_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String inputStationToRegister(){
        System.out.println(REGISTER_STATION_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String inputStationToRemove(){
        System.out.println(REMOVE_STATION_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String inputLineToRegister(){
        System.out.println(REGISTER_LINE_MESSAGE.getMessage());
        return Console.readLine();
    }

    public String inputLineToRemove(){
        System.out.println(REMOVE_LINE_MESSAGE.getMessage());
        return Console.readLine();
    }
}
