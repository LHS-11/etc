package baseball.view;

import java.util.Scanner;

public class InputView {

    private String input;

    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public String playerInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        input=scanner.next();
        return input;
    }
}
