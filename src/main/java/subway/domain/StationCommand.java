package subway.domain;

import java.util.Arrays;

import static subway.constants.ErrorMessage.FUNCTION_COMMAND_ERROR_MESSAGE;

public enum StationCommand {

    FIRST("1","1. 역 등록"),
    SECOND("2","2. 역 삭제"),
    THIRD("3","3. 역 조회"),
    FOURTH("4","B. 돌아가기");

    private String command;
    private String name;

    StationCommand(String command, String name) {
        this.command = command;
        this.name = name;
    }

    public static void validateStationCommand(String command){
        Arrays.stream(StationCommand.values())
                .filter(c -> c.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(FUNCTION_COMMAND_ERROR_MESSAGE.getMessage()));
    }

}
