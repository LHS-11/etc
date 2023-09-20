package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingInfo {

    private Course course;
    private Level level;
    private Mission mission;

    public MatchingInfo(String matchingInfo){
        List<String> parsedMatchingInfo = parsingMatchingInfo(matchingInfo);
        validateMatchingInfo(parsedMatchingInfo);
        course = Course.findCourse(parsedMatchingInfo.get(0));
        level = Level.findLevel(parsedMatchingInfo.get(1));
        mission = Mission.findMission(parsedMatchingInfo.get(2));
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }

    public void validateMatchingInfo(List<String> parsedMatchingInfo){
        validateCourse(parsedMatchingInfo.get(0));
        validateLevel(parsedMatchingInfo.get(1));
        validateMission(parsedMatchingInfo.get(2));
    }

    private static void validateMission(String mission) {
        if(Mission.findMission(mission)==Mission.EMPTY){
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 미션입니다.");
        }
        if(Level.isCorrectMission(mission)){
            return;
        }
        throw new IllegalArgumentException("[ERROR] 레벨에 존재하지 않는 미션입니다.");
    }

    private static void validateLevel(String level) {
        if(Level.findLevel(level)==Level.EMPTY){
            throw new IllegalArgumentException("[ERROR] 레벨은 레벨1~5까지만 존재합니다.");
        }
    }

    private static void validateCourse(String course) {
        if(Course.findCourse(course)==Course.EMPTY){
            throw new IllegalArgumentException("[ERROR] 과정은 백엔드, 프론트엔드만 존재합니다.");
        }
    }

    public List<String> parsingMatchingInfo(String matchingInfo){
        String[] split = matchingInfo.split(",");
        return Arrays.stream(split)
                .map(s -> s.trim())
                .collect(Collectors.toList());

    }
}
