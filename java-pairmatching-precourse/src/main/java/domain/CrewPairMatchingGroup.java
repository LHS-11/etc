package domain;

import java.util.ArrayList;
import java.util.Arrays;
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


    public List<CrewPairMatchingInfo> findCrewPairInfoSameLevel(CrewPairMatchingInfo crewPairMatchingInfo) {
        return crewPairMatchingInfoGroup.stream()
                .filter(crewInfo -> crewInfo.isSameLevel(crewPairMatchingInfo))
                .collect(Collectors.toList());
    }

    public boolean isDuplicatedPairMatching(CrewPairMatchingInfo crewPairMatchingInfo) {
        List<CrewPairMatchingInfo> crewPairInfoSameLevel = findCrewPairInfoSameLevel(crewPairMatchingInfo);
        List<List<CrewPair>> collect = crewPairInfoSameLevel.stream()
                .map(c -> c.getCrewPairs())
                .collect(Collectors.toList());

        return collect.stream()
                .filter(c -> crewPairMatchingInfo.getCrewPairs().stream().anyMatch(crew -> c.containsAll(crew.getCrewPairInfo())))
                .findAny()
                .isPresent();

    }

    public boolean isSameCrewPairMatchingInfo(CrewPairMatchingInfo other){
        return crewPairMatchingInfoGroup.stream()
                .anyMatch(c -> c.isSameCrewPairInfo(other));
    }

    public CrewPairMatchingInfo findCrewPairMatching(CrewPairMatchingInfo other){
        return crewPairMatchingInfoGroup.stream()
                .filter(c -> c.isSameCrewPairInfo(other))
                .findFirst()
                .get();
    }

}
