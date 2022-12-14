package subway.controller;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.FunctionCommand.*;
import static subway.domain.StationRepository.*;

public class SubwayController {

    private final InputView inputView;
    private final OutputView outputView;

    public SubwayController(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void go(){

    }

    public void start(){

        while (true){
            try {
                outputView.printMainView();
                String functionCommand = inputView.inputFunction();
                validateCommand(functionCommand);
                playFunction(functionCommand);
                if(functionCommand.equals("Q")){
                    break;
                }
            }catch (IllegalArgumentException e){
                outputView.printErrorMessage(e.getMessage());
            }

        }
    }

    public void playFunction(String functionCommand){
        selectStationManagement(functionCommand);
        if(functionCommand .equals("2")){
            
        }
        if(functionCommand .equals("3")){
            
        }
        if(functionCommand .equals("4")){
            
        }

    }

    public void selectStationManagement(String functionCommand) {
        if(functionCommand .equals("1")){
            outputView.printStationControlView();
            Station station= getStation();
            addStation(station);
            outputView.printStationSuccess();
        }
    }

    public Station getStation() {
        try {
            Station station = new Station(inputView.inputStationToRegister());
            validateDuplicatedStation(station);
            return station;
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return getStation();
        }
    }
}
