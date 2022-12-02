package domain;

public enum Mission {
    CAR_GAME("자동차경주"),
    LOTTO("로또"),
    BASEBALL_GAME("숫자야구게임"),
    PERFORMANCE_IMPROVEMENT("성능개선"),
    DISTRIBUTION("배포");

    private String name;

    Mission(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
