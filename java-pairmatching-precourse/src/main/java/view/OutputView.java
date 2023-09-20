package view;

import domain.CrewPair;

import java.util.List;

public class OutputView {

    public void printError(String message){
        System.out.println(message);
    }

    public void printPairMatchingResult(List<CrewPair> crewPairs){
        for (CrewPair crewPair : crewPairs) {
            List<String> crewPairInfo = crewPair.getCrewPairInfo();
            for (int i = 0; i < crewPairInfo.size(); i++) {
                System.out.print(crewPairInfo.get(i));
                if(i!=crewPairInfo.size()-1){
                    System.out.print(" : ");
                }
            }
            System.out.println();
        }
    }
}
