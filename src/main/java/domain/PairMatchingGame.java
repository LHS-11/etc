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

    private int retryCount=0;

    public CrewInfo getFrontEndCrews() {
        return frontEndCrews;
    }

    public CrewInfo getBackEndCrews() {
        return backEndCrews;
    }

    public PairMatchingGame() {
        crewRandomGenerator = new CrewRandomGenerator();
        pairMatchingFileReader = new PairMatchingFileReader();
        crewPairMatchingGroup = new CrewPairMatchingGroup();
        backEndCrews = new CrewInfo(Course.BACKEND, getFile(Course.BACKEND));
        frontEndCrews = new CrewInfo(Course.FRONTEND, getFile(Course.FRONTEND));
    }

    public int getRetryCount() {
        return retryCount;
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

    public CrewPairMatchingInfo matchPair(Course course,Level level,Mission mission){
        List<CrewPair> crewPairs = null;
        CrewPairMatchingInfo crewPairMatchingInfo = null;
        retryCount+=1;

        if(course==Course.BACKEND){
            List<String> shuffleCrews = shuffleCrews(backEndCrews);
            crewPairs = PairMatcher.matchPairs(shuffleCrews);
            crewPairMatchingInfo = new CrewPairMatchingInfo(Course.BACKEND, level, mission, crewPairs);
        }
        if(course==Course.FRONTEND){
            List<String> shuffleCrews = shuffleCrews(frontEndCrews);
            crewPairs = PairMatcher.matchPairs(shuffleCrews);
            crewPairMatchingInfo = new CrewPairMatchingInfo(Course.BACKEND, level, mission, crewPairs);
        }
        crewPairMatchingGroup.addCrewPairMatingInfo(crewPairMatchingInfo);

        return crewPairMatchingInfo;
    }

    public boolean isDuplicatedPair(CrewPairMatchingInfo crewPairMatchingInfo){
        if(crewPairMatchingGroup.isDuplicatedPairMatching(crewPairMatchingInfo)){
            return true;
        }
        return false;
    }

    public boolean isPresentPairInfo(CrewPairMatchingInfo crewPairMatchingInfo){
        if(crewPairMatchingInfo.isSameCrewPairInfo(crewPairMatchingInfo)){
            return true;
        }
        return false;
    }

    public CrewPairMatchingInfo findCrewPairMatchingInfo(CrewPairMatchingInfo crewPairMatchingInfo){
        return crewPairMatchingGroup.findCrewPairMatching(crewPairMatchingInfo);
    }


}
