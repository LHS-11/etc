package domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드"),
    EMPTY("EMPTY");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course findCourse(String course){
        return Arrays.stream(Course.values())
                .filter(c -> c.name.equals( course))
                .findFirst()
                .orElse(EMPTY);
    }

    public String getName() {
        return name;
    }
}
