package subway.controller;

import com.sun.tools.javac.Main;
import subway.domain.MainCommand;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.EnumMap;
import java.util.Map;

public class MainController implements Controller{

    private final Map<MainCommand,Controller> controllers;
    private final InputView inputView;
    private final OutputView outputView;

    public MainController(){
        controllers = new EnumMap<MainCommand, Controller>(MainCommand.class);
        inputView = new InputView();
        outputView = new OutputView();
        initController();
    }

    public void initController(){
        controllers.put(MainCommand.FIRST, new RouteReadingController());
        controllers.put(MainCommand.SECOND, new QuitController());
    }


    @Override
    public void play() {
        InitController.init();
        MainCommand mainCommand = null;
        do{
            outputView.printMainMenu();
            mainCommand = getMainCommand(mainCommand);
            controllers.get(mainCommand).play();
        }while (!mainCommand.isClose());
    }


    private MainCommand getMainCommand(MainCommand mainCommand) {
        try {
            mainCommand = MainCommand.from(inputView.inputMainCommand());
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return getMainCommand(mainCommand);
        }
        return mainCommand;
    }
}
