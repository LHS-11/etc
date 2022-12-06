package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;
import controller.PairMatchingController;
import domain.*;
import view.InputView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args)  {
        // TODO 구현 진행
        PairMatchingController pairMatchingController = new PairMatchingController();
//        pairMatchingController.go();
        Level.LEVEL1.add(Arrays.asList("미애","오주"));
        Level.LEVEL1.add(Arrays.asList("수정","지연"));
        Level.LEVEL1.add(Arrays.asList("정수","지수"));

        List<List<String>> crewPairInfo = Level.LEVEL1.getCrewPairInfo();

        for (List<String> list : crewPairInfo) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if(i!=list.size()-1){
                    System.out.print(" : ");
                }
            }
            System.out.println();
        }


    }

}
