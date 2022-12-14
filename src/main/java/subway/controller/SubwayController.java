package subway.controller;

import subway.domain.LineCommand;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationCommand;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.FunctionCommand.*;
import static subway.domain.LineCommand.*;
import static subway.domain.LineRepository.lines;
import static subway.domain.StationCommand.*;
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
                validateFunctionCommand(functionCommand);
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
        selectLineManagement(functionCommand);
        if(functionCommand .equals("3")){
            
        }
        if(functionCommand .equals("4")){
            
        }

    }

    public void selectLineManagement(String functionCommand) {
        if(functionCommand.equals("2")){
           outputView.printLineControlView();
            String lineFunctionCommand = getLineFunctionCommand();
//            selectLineRegistration(lineFunctionCommand);
            selectLineRemove(lineFunctionCommand);
            selectLineReading(lineFunctionCommand);
        }
    }

    private void selectLineRemove(String lineFunctionCommand) {
        if(lineFunctionCommand.equals("2")){

        }
    }

    private void selectLineReading(String lineFunctionCommand) {
        if(lineFunctionCommand.equals("3")){
            outputView.printLineInfo(lines());
        }
    }

    private String getLineFunctionCommand() {
        try {
            String lineFunctionCommand = inputView.inputFunction();
            validateLineCommand(lineFunctionCommand);
            return lineFunctionCommand;
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return getStationFunctionCommand();
        }

    }

    public void selectStationManagement(String functionCommand) {
        if(functionCommand .equals("1")){
            outputView.printStationControlView();
            String stationFunctionCommand = getStationFunctionCommand();
            selectStationRegistration(stationFunctionCommand);
            selectStationRemove(stationFunctionCommand);
            selectStationReading(stationFunctionCommand);

        }
    }

    private String getStationFunctionCommand() {
        try {
            String stationFunctionCommand = inputView.inputFunction();
            validateStationCommand(stationFunctionCommand);
            return stationFunctionCommand;
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return getStationFunctionCommand();
        }

    }

    public void selectStationRegistration(String stationFunctionCommand) {
        if(stationFunctionCommand.equals("1")){
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
    public void selectStationRemove(String stationFunctionCommand) {
        if(stationFunctionCommand.equals("2")){
            Station station = getStationToRemove();
            deleteStation(station.getName());
            outputView.printStationRemoving();
        }
    }

    private Station getStationToRemove() {
        try {
            Station station = new Station(inputView.inputStationToRemove());
            validatePresentStation(station);
            return station;
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return getStation();
        }
    }

    public void selectStationReading(String stationFunctionCommand) {
        if(stationFunctionCommand.equals("3")){
           outputView.printStationInfo(stations());
        }
    }


}
