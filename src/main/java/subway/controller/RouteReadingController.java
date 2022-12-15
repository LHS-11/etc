package subway.controller;

import subway.domain.RouteCriteriaCommand;
import subway.domain.RouteRepository;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.RouteCriteriaCommand.*;

public class RouteReadingController implements Controller{

    private final InputView inputView;
    private final OutputView outputView;

    public RouteReadingController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    @Override
    public void play() {
        RouteCriteriaCommand command = from(inputView.inputMainCommand());
        readShortestDistance(command);
        if(command.equals(MINIMUM_TIME)){

        }
    }

    private static void readShortestDistance(RouteCriteriaCommand command) {
        if(command.equals(MINIMUM_ROUTE)){

        }
    }
}
