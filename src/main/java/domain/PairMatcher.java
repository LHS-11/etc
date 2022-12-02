package domain;

import java.util.ArrayList;
import java.util.List;

public class PairMatcher {

    public List<List<String>> matchPairs(List<String> shuffledCrew) {
        List<List<String>> pairGroup = new ArrayList<>();
        if (checkGroupSizeEven(shuffledCrew)) {
            matchPairsEvenSize(shuffledCrew, pairGroup);
        }
        if (!checkGroupSizeEven(shuffledCrew)) {
            matchPairsEvenSize(shuffledCrew, pairGroup);
            matchLastCrew(shuffledCrew, pairGroup);
        }
        return pairGroup;
    }

    private static void matchPairsEvenSize(List<String> shuffledCrew, List<List<String>> pairGroup) {
        for (int i = 0; i < shuffledCrew.size(); i+=2) {
            List<String> pair = new ArrayList<>();
            for (int j = i; j < i + 2; j++) {
                pair.add(shuffledCrew.get(j));
            }
            pairGroup.add(pair);
        }
    }

    private static void matchLastCrew(List<String> shuffledCrew, List<List<String>> pairGroup) {
        List<String> lastPair = pairGroup.get(pairGroup.size() - 1);
        lastPair.add(shuffledCrew.get(shuffledCrew.size() - 1));
        pairGroup.set(pairGroup.size() - 1, lastPair);
    }

    public boolean checkGroupSizeEven(List<String> group) {
        return group.size() % 2 == 0;
    }


}
