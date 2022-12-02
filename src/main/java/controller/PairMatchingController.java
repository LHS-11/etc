package controller;

import domain.PairMatchingGame;
import validation.InputValidator;
import view.InputView;
import view.OutputView;

public class PairMatchingController {

    private final InputView inputView;
    private final OutputView outputView;
    private static PairMatchingGame pairMatchingGame = new PairMatchingGame();

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void go(){

    }

    public void start(){
        String pairMatching = getPairMatching();
        matchPairs(pairMatching);
        if(pairMatching.equals("2")){

        }
        if(pairMatching.equals("3")){

        }
        if(pairMatching.equals("Q")){

        }
    }

    public void matchPairs(String pairMatching) {
        if(pairMatching.equals("1")){
            String pairMatchingInfo=inputView.selectPairMatching();
        }
    }

    private String getPairMatching() {
        try {
            String feature = inputView.selectFeature();
            InputValidator.validateFeatureInput(feature);
            return feature;

        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return getPairMatching();
        }
    }
}
