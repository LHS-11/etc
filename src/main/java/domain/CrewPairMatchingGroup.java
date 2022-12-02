package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrewPairMatchingGroup {

    private List<CrewPairMatchingInfo> crewPairMatchingInfoGroup;

    public CrewPairMatchingGroup() {
        crewPairMatchingInfoGroup = new ArrayList<>();
    }

    public void addCrewPairMatingInfo(CrewPairMatchingInfo crewPairMatchingInfo) {
        crewPairMatchingInfoGroup.add(crewPairMatchingInfo);
    }


    private List<CrewPairMatchingInfo> findCrewPairInfoSameLevel(CrewPairMatchingInfo crewPairMatchingInfo) {
        return crewPairMatchingInfoGroup.stream()
                .filter(crewInfo -> crewInfo.isSameLevel(crewPairMatchingInfo))
                .collect(Collectors.toList());
    }

}
