package domain;

import java.util.Arrays;

public enum Mission {
    CAR_GAME("자동차경주"),
    LOTTO("로또"),
    BASEBALL_GAME("숫자야구게임"),
    PERFORMANCE_IMPROVEMENT("성능개선"),
    DISTRIBUTION("배포"),
    EMPTY("없음");

    private String name;

    Mission(String name){
        this.name = name;
    }

    public static Mission findMission(String missionName){
        return Arrays.stream(Mission.values())
                .filter(m -> m.name.equals(missionName))
                .findAny()
                .orElse(EMPTY);
    }

    public String getName() {
        return name;
    }
}
