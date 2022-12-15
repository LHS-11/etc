package subway.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String COMMAND_INPUT_VIEW_MESSAGE = "## 원하는 기능을 선택하세요.";

    public String inputMainCommand(){
        System.out.println(COMMAND_INPUT_VIEW_MESSAGE);
        return Console.readLine();
    }
}
