package baseball;

import baseball.model.Computer;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 컴퓨터_숫자_생성기_크기_테스트() {
        Computer computer = new Computer();
        computer.generateComputerNumberThree();
        assertThat(computer.getComputerNumber().size()).isEqualTo(3);

    }

    @Test
    void 컴퓨터_숫자_생성기_범위_테스트() {
        Computer computer = new Computer();
        computer.generateComputerNumberThree();
        ArrayList<Integer> computerNumber = computer.getComputerNumber();
        assertThat(computerNumber).containsAnyOf(1,2,3,4,5,6,7,8,9);

        for (Integer num : computerNumber) {
            Assertions.assertTrue(num>=1 && num<=9);
        }
    }

    @Test
    void 컴퓨터_숫자_중복_숫자_테스트(){
        Computer computer = new Computer();
        computer.generateComputerNumberThree();
        ArrayList<Integer> computerNumber = computer.getComputerNumber();
        assertThat(computerNumber).doesNotHaveDuplicates();

    }

    @Test
    void 컴퓨터_숫자_플레이어_숫자_스트라이크_카운트_테스트(){
        Computer computer = new Computer();
        int strike = computer.countStrike(new ArrayList<>(List.of(1, 2, 3)), new ArrayList<Integer>(List.of(1, 2, 3)));
        assertThat(3).isEqualTo(strike);
    }

    @Test
    void 컴퓨터_숫자_플레이어_숫자_볼_카운트_테스트(){
        Computer computer = new Computer();
        int ball = computer.countBall(new ArrayList<>(List.of(7, 1, 3)), new ArrayList<Integer>(List.of(7, 1, 3)));
        assertThat(0).isEqualTo(ball);
    }
}
