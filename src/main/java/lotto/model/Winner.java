package lotto.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class Winner {

    private final List<Integer> lottoWinningNumber;

    public Winner(String lottoWinningNumber) {
        checkLottoWinningNumber(lottoWinningNumber);
        this.lottoWinningNumber = getLottoWinningNumberParsing(lottoWinningNumber);
    }

    public List<Integer> getLottoWinningNumber() {
        return lottoWinningNumber;
    }

    public List<Integer> getLottoWinningNumberParsing(String lottoNumber) {
        List<Integer> lottoWinningNumber = new ArrayList<>();
        String[] lottoNumbersOnly = lottoNumber.split(",");
        for (String lottoNumberOnly : lottoNumbersOnly) {
            int lottoNumberParsing = Integer.parseInt(lottoNumberOnly);
            lottoWinningNumber.add(lottoNumberParsing);
        }
        return lottoWinningNumber;
    }

    public void checkLottoWinningNumber(String lottoNumber) {
        checkLottoWinningNumberFormat(lottoNumber);
        checkLottoWinningNumberRange(lottoNumber);
    }


    private static void checkLottoWinningNumberRange(String lottoNumber) {
        String[] lottoNumbersOnly = lottoNumber.split(",");
        for (String lottoNumberOnly : lottoNumbersOnly) {
            int lottoNumberParsing = Integer.parseInt(lottoNumberOnly);
            throwLottoWinningNumberException(lottoNumberParsing);
        }
    }

    private static void throwLottoWinningNumberException(int lottoNumberParsing) {
        if (lottoNumberParsing >= 1 && lottoNumberParsing <= 45) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] : 당첨 번호의 범위를 벗어났습니다.");
    }

    private static void checkLottoWinningNumberFormat(String lottoNumber) {
        if (isLottoNumberFormat(lottoNumber)) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] : 당첨 번호 형식에 맞지 않습니다.");
    }

    private static boolean isLottoNumberFormat(String lottoNumber) {
        boolean found = false;

        String regex = "^[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1}" +
                ",[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lottoNumber);
        if (matcher.matches()) {
            found = true;
        }
        return found;
    }
}
