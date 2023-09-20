package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CrewRandomGenerator {

    public List<String> shuffleCrew(List<String> crewGroup){
        List<String> shuffledCrew = Randoms.shuffle(crewGroup);
        return shuffledCrew;
    }
}
