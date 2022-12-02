package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        InputView inputView = new InputView();
        inputView.selectFeature();
        inputView.selectPairMatching();
        inputView.selectPairMatchingRetry();
    }
}
