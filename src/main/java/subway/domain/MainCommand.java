package subway.domain;

import java.util.Arrays;
import java.util.Objects;

import static subway.constants.ErrorMessage.COMMAND_INPUT_ERROR_MESSAGE;

public enum MainCommand {

    FIRST("1", "1. 경로 조회"),
    SECOND("Q", "Q. 종료");

    private String command;
    private String name;

    MainCommand(String command, String name) {
        this.command = command;
        this.name = name;
    }
    public String getCommand() {
        return command;
    }
    public static MainCommand from(String other) {
        return Arrays.stream(MainCommand.values())
                .filter(m -> Objects.equals(m.command, other.trim()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(COMMAND_INPUT_ERROR_MESSAGE.getMessage()));
    }
    public boolean isClose(){
        return this==SECOND;
    }
}
