package subway.controller;

import subway.domain.RouteCriteriaCommand;
import subway.domain.RouteRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.RouteCriteriaCommand.*;
import static subway.domain.StationRepository.*;

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

    private void readShortestDistance(RouteCriteriaCommand command) {
        if(command.equals(MINIMUM_ROUTE)){
            Station startStation = getStation();

        }
    }

    private Station getStation() {
        try {
            Station station = new Station(inputView.inputStartStation());
            validatePresentStation(station);
            return station;
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return getStation();
        }
    }
}
