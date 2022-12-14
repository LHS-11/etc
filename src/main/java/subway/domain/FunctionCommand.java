package subway.domain;

import java.util.Arrays;

import static subway.constants.ErrorMessage.FUNCTION_COMMAND_ERROR_MESSAGE;

public enum FunctionCommand {

    FIRST("1","1. 역 관리"),
    SECOND("2","2. 노선 관리"),
    THIRD("3","3. 구간 관리"),
    FOURTH("4","4. 지하철 노선도 출력"),
    FIFTH("Q", "Q. 종료");

    private String command;
    private String name;

    FunctionCommand(String command, String name) {
        this.command = command;
        this.name = name;
    }

    public static void validateCommand(String command){
        Arrays.stream(FunctionCommand.values())
                .filter(c -> c.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(FUNCTION_COMMAND_ERROR_MESSAGE.getMessage()));
    }
}
