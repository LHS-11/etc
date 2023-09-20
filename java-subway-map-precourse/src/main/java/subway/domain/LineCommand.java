package subway.domain;

import java.util.Arrays;

import static subway.constants.ErrorMessage.FUNCTION_COMMAND_ERROR_MESSAGE;

public enum LineCommand {

    FIRST("1","1. 노선 등록"),
    SECOND("2","2. 노선 삭제"),
    THIRD("3","3. 노선 조회"),
    FOURTH("B","B. 돌아가기");

    private String command;
    private String name;

    LineCommand(String command, String name) {
        this.command = command;
        this.name = name;
    }

    public static void validateLineCommand(String command){
        Arrays.stream(LineCommand.values())
                .filter(c -> c.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(FUNCTION_COMMAND_ERROR_MESSAGE.getMessage()));
    }
}
