package subway.domain;

import java.util.Arrays;
import java.util.Objects;

public enum MainCommand {

    FIRST("1", "1. 경로 조회"),
    SECOND("Q", "Q. 종료");

    private String command;
    private String name;

    MainCommand(String command, String name) {
        this.command = command;
        this.name = name;
    }

    public static MainCommand from(String other) {
        return Arrays.stream(MainCommand.values())
                .filter(m -> Objects.equals(m.command, other))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] : 문자를 잘못 입력하셨습니다."));
    }

    public String getCommand() {
        return command;
    }

    public boolean isClose(){
        return this==SECOND;
    }
}
