package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private Computer computer = new Computer();
    private Player player;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start() {

        inputView.printGameStart();
        computer.generateComputerNumberThree();
        play();
        outputView.printGameEnd();
        restartOrClose();

    }

    private void play() {
        String hint;
        do {
            String input = inputView.playerInput();

            player = new Player(input);
            player.checkException();
            player.setInputNumber();

            hint = computer.getHint(computer.getComputerNumber(), player.getInputNumber());

            outputView.printHint(hint);
        } while (computer.isNotThreeStrike(hint));
    }

    public void restartOrClose() {
        String restartInput = inputView.restart();
        if (computer.isRestart(restartInput)) {
            start();
        }
        if(!computer.isRestart(restartInput)){
            System.exit(0);
        }
    }

    public void setInputView(InputView inputView){
        this.inputView = inputView;
    }
}
