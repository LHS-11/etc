package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static domain.Level.*;
import static domain.Mission.*;

public class PairMatchingGame {
    private final CrewRandomGenerator crewRandomGenerator;
    private final PairMatchingFileReader pairMatchingFileReader;
    private final CrewPairMatchingGroup crewPairMatchingGroup;
    private CrewPairMatchingInfo crewPairMatchingInfo;
    private CrewInfo frontEndCrews;
    private CrewInfo backEndCrews;


    public PairMatchingGame() {
        crewRandomGenerator = new CrewRandomGenerator();
        pairMatchingFileReader = new PairMatchingFileReader();
        crewPairMatchingGroup = new CrewPairMatchingGroup();
        frontEndCrews = new CrewInfo(Course.BACKEND, getFile(Course.BACKEND));
        backEndCrews = new CrewInfo(Course.FRONTEND, getFile(Course.FRONTEND));
    }

    public List<String> getFile(Course course) {
        try {
            List<String> crewName = null;
            if (course == Course.BACKEND) {
                 crewName=new ArrayList<>(pairMatchingFileReader.backEndReader());
            }
            if (course == Course.FRONTEND) {
                crewName=new ArrayList<>(pairMatchingFileReader.frontEndReader());
            }
            return crewName;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> shuffleCrews(CrewInfo crewInfo){
        return crewRandomGenerator.shuffleCrew(crewInfo.getNames());
    }

    public List<CrewPair> matchPair(String course,String level,String mission){
        List<CrewPair> crewPairs = null;
        if(course==Course.BACKEND.name()){
            List<String> shuffleCrews = shuffleCrews(backEndCrews);
            crewPairs = PairMatcher.matchPairs(shuffleCrews);
            crewPairMatchingGroup.addCrewPairMatingInfo( new CrewPairMatchingInfo(Course.BACKEND, findLevel(level), findMission(mission), crewPairs));
        }
        if(course==Course.FRONTEND.name()){
            List<String> shuffleCrews = shuffleCrews(frontEndCrews);
            crewPairs = PairMatcher.matchPairs(shuffleCrews);
            crewPairMatchingGroup.addCrewPairMatingInfo( new CrewPairMatchingInfo(Course.BACKEND, findLevel(level), findMission(mission), crewPairs));
        }
        return crewPairs;
    }


}
