package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        List<String> crewList=new ArrayList<>();
        crewList.add("a");
        crewList.add("b");
        crewList.add("c");
        crewList.add("d");

        List<String> shuffle = Randoms.shuffle(crewList);
        for (String s : shuffle) {
            System.out.println(s);
        }
    }
}
