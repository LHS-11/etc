package subway.controller;

import subway.domain.FunctionCommand;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.FunctionCommand.*;

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
            }catch (IllegalArgumentException e){
                outputView.printErrorMessage(e.getMessage());
            }

        }
    }

    public void playFunction(String functionCommand){

    }
}
