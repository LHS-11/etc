package domain;

import java.util.List;

public class CrewInfo {

    private Course course;

    private List<String> names;

    public CrewInfo(Course course, List<String> names) {
        this.course = course;
        this.names = names;
    }

    public Course getCourse() {
        return course;
    }

    public List<String> getNames() {
        return names;
    }
}
