package domain;

import java.util.ArrayList;
import java.util.List;

public class PairMatcher {

    public List<CrewPair> matchPairs(List<String> shuffledCrew) {
        List<CrewPair> pairGroup = new ArrayList<>();
        if (checkGroupSizeEven(shuffledCrew)) {
            matchPairsEvenSize(shuffledCrew, pairGroup);
        }
        if (!checkGroupSizeEven(shuffledCrew)) {
            matchPairsEvenSize(shuffledCrew, pairGroup);
            matchLastCrew(shuffledCrew, pairGroup);
        }
        return pairGroup;
    }

    private static void matchPairsEvenSize(List<String> shuffledCrew, List<CrewPair> pairGroup) {
        for (int i = 0; i < shuffledCrew.size(); i+=2) {
            CrewPair pair = new CrewPair();
            for (int j = i; j < i + 2; j++) {
                pair.addCrew(shuffledCrew.get(j));
            }
            pairGroup.add(pair);
        }
    }

    private static void matchLastCrew(List<String> shuffledCrew, List<CrewPair> pairGroup) {
        CrewPair lastCrewPair = pairGroup.get(pairGroup.size() - 1);
        lastCrewPair.addCrew(shuffledCrew.get(shuffledCrew.size() - 1));
        pairGroup.set(pairGroup.size() - 1, lastCrewPair);
    }

    public boolean checkGroupSizeEven(List<String> group) {
        return group.size() % 2 == 0;
    }


}
