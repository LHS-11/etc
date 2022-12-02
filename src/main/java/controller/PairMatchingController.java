package controller;

import validation.InputValidator;
import view.InputView;
import view.OutputView;

public class PairMatchingController {

    private final InputView inputView;
    private final OutputView outputView;

    public PairMatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void go(){

    }

    public void start(){
        String pairMatching = getPairMatching();

    }

    private String getPairMatching() {
        try {
            String selectPairMatching = inputView.selectPairMatching();
            InputValidator.validateFeatureInput(selectPairMatching);
            return selectPairMatching;

        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return getPairMatching();
        }
    }
}
