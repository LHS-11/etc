package domain;

import java.util.ArrayList;
import java.util.List;

public class CrewPair {

    private List<String> crewPairInfo;

    public CrewPair() {
        this.crewPairInfo = new ArrayList<>();
    }

    public List<String> getCrewPairInfo() {
        return crewPairInfo;
    }

    public void addCrew(String crew){
        crewPairInfo.add(crew);
    }

    public boolean isSameCrewPair(CrewPair crewPair){
        return this.crewPairInfo.containsAll(crewPair.getCrewPairInfo());
    }
}
