package subway.controller;

import subway.domain.Criteria;
import subway.domain.RouteCriteriaCommand;
import subway.domain.RouteRepository;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

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
        outputView.printRouteMenu();
        RouteCriteriaCommand command = from(inputView.inputMainCommand());
        readShortestDistance(command,Criteria.DISTANCE);
        readShortestTime(command,Criteria.TIME);
    }


    private void makeShortestRoute(Criteria criteria) {
        Station startStation = getStartStation();
        Station endStation = getEndStation(startStation);
        List<String> shortestPathName = RouteRepository.getDijkstraShortestPath(startStation, endStation, criteria);
        try {
            validateSameStation(startStation,endStation);
            int distanceAmount = RouteRepository.getDistanceAmount(shortestPathName);
            int timeAmount = RouteRepository.getTimeAmount(shortestPathName);
            outputView.printResult(distanceAmount, timeAmount, shortestPathName);
        }catch (Exception e){
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private Station getStartStation() {
        try {
            Station station = new Station(inputView.inputStartStation());
            validatePresentStation(station);
            return station;
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return getStartStation();
        }
    }

    private Station getEndStation(Station startStation) {
        try {
            Station endStation = new Station(inputView.inputEndStation());
            validatePresentStation(endStation);
            return endStation;
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return getEndStation(startStation);
        }
    }
    private void readShortestTime(RouteCriteriaCommand command,Criteria criteria) {
        if(command.equals(MINIMUM_TIME)){
            makeShortestRoute(criteria);
        }
    }

    private void readShortestDistance(RouteCriteriaCommand command, Criteria criteria) {
        if(command.equals(MINIMUM_ROUTE)){
            makeShortestRoute(criteria);
        }
    }


}
