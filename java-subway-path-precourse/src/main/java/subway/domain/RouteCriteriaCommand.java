package subway.domain;

import subway.constants.ErrorMessage;

import java.util.Arrays;
import java.util.Objects;

import static subway.constants.ErrorMessage.*;

public enum RouteCriteriaCommand {

    MINIMUM_ROUTE("1","1. 최단 거리"),
    MINIMUM_TIME("2","2. 최소 시간"),
    BACK("B","B. 돌아가기");

    private String command;
    private String name;

    RouteCriteriaCommand(String command, String name) {
        this.command = command;
        this.name = name;
    }

    public String getCommand() {
        return command;
    }

    public static RouteCriteriaCommand from(String other){
        return Arrays.stream(RouteCriteriaCommand.values())
                .filter(r -> Objects.equals(r.command, other.trim()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(COMMAND_INPUT_ERROR_MESSAGE.getMessage()));
    }
}
