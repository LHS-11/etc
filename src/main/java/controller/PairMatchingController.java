package controller;

import domain.CrewPair;
import domain.CrewPairMatchingInfo;
import domain.MatchingInfo;
import domain.PairMatchingGame;
import validation.InputValidator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class PairMatchingController {

    private final InputView inputView;
    private final OutputView outputView;
    private static PairMatchingGame pairMatchingGame = new PairMatchingGame();

    public PairMatchingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void go() {
        start();
    }

    public void start() {
        while (true) {
            String pairMatching = getPairMatching();
            matchPairs(pairMatching);
            readMatchPairs(pairMatching);
            initMatchPairs(pairMatching);
            if (pairMatching.equals("Q")) {
                break;
            }
        }
    }

    private static void initMatchPairs(String pairMatching) {
        if (pairMatching.equals("3")) {
            pairMatchingGame = new PairMatchingGame();
        }
    }

    private void readMatchPairs(String pairMatching) {
        if (pairMatching.equals("2")) {
            MatchingInfo matchingInfo = getMatchingInfo();
            CrewPairMatchingInfo crewPairMatchingInfo = new CrewPairMatchingInfo(matchingInfo.getCourse()
                    , matchingInfo.getLevel(), matchingInfo.getMission(), null);
            if(pairMatchingGame.isPresentPairInfo(crewPairMatchingInfo)){
                outputView.printPairMatchingResult(pairMatchingGame.findCrewPairMatchingInfo(crewPairMatchingInfo).getCrewPairs());
            }else{
                throw new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다.");
            }
        }
    }

    public void matchPairs(String pairMatching) {
        if (pairMatching.equals("1")) {
            MatchingInfo matchingInfo = getMatchingInfo();
            CrewPairMatchingInfo crewPairMatchingInfo = new CrewPairMatchingInfo(matchingInfo.getCourse()
                    , matchingInfo.getLevel(), matchingInfo.getMission(), null);
            if(pairMatchingGame.isPresentPairInfo(crewPairMatchingInfo)){
                String input = inputView.selectPairMatchingRetry();

            }
            if(!pairMatchingGame.isPresentPairInfo(crewPairMatchingInfo)){
                crewPairMatchingInfo = pairMatchingGame.matchPair(matchingInfo.getCourse(), matchingInfo.getLevel(), matchingInfo.getMission());
            }

            do {
                crewPairMatchingInfo = pairMatchingGame.matchPair(matchingInfo.getCourse(), matchingInfo.getLevel(), matchingInfo.getMission());
                if(pairMatchingGame.getRetryCount()>3){
                    throw new IllegalArgumentException("[ERROR] : 매칭 실패 ");
                }
            } while (!pairMatchingGame.isDuplicatedPair(crewPairMatchingInfo));
            List<CrewPair> crewPairs = crewPairMatchingInfo.getCrewPairs();
            outputView.printPairMatchingResult(crewPairs);
        }
    }

    private MatchingInfo getMatchingInfo() {
        try {
            return new MatchingInfo(inputView.selectPairMatching());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getMatchingInfo();
        }
    }

    private String getPairMatching() {
        try {
            String feature = inputView.selectFeature();
            InputValidator.validateFeatureInput(feature);
            return feature;

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return getPairMatching();
        }
    }
}
