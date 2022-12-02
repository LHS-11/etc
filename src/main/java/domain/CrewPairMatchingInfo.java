package domain;

import java.util.List;

public class CrewPairMatchingInfo {

    private Course course;
    private Level level;

    private Mission mission;
    private List<List<String>> pairMatchingInfo;

    public CrewPairMatchingInfo(Course course, Level level, Mission mission, List<List<String>> pairMatchingInfo) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.pairMatchingInfo = pairMatchingInfo;
    }

    public List<List<String>> getPairMatchingInfo() {
        return pairMatchingInfo;
    }
}
