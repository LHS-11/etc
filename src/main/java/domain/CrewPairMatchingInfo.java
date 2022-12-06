package domain;

import java.util.List;

public class CrewPairMatchingInfo {

    private Course course;
    private Level level;
    private Mission mission;
    private List<CrewPair> crewPairs;

    public CrewPairMatchingInfo(Course course, Level level, Mission mission, List<CrewPair> crewPairs) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.crewPairs = crewPairs;
    }


    public List<CrewPair> getCrewPairs() {
        return crewPairs;
    }

    public boolean isSameLevel(CrewPairMatchingInfo other){
        return other.level == this.level;
    }

    public boolean isSameCrewPair(List<CrewPair> other){
        return other.containsAll(crewPairs);
    }

    public boolean isSameCrewPairInfo(CrewPairMatchingInfo other){
        return other.level == this.level && other.course == this.course && other.mission == this.mission;
    }
}
