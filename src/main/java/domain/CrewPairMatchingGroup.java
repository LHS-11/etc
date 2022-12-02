package domain;

import java.util.ArrayList;
import java.util.List;

public class CrewPairMatchingGroup {

    private List<CrewPairMatchingInfo> crewPairMatchingInfos;

    public CrewPairMatchingGroup(){
        crewPairMatchingInfos = new ArrayList<>();
    }

    public void addCrewPairMatingInfo(CrewPairMatchingInfo crewPairMatchingInfo){
        crewPairMatchingInfos.add(crewPairMatchingInfo);
    }


}
