package lotto.constValue;

public final class Constants {

    public class ExceptionMessage{
        public static final String MONEY_INPUT_NON_NUMBER_ERROR_MESSAGE = "[ERROR] : 구입 금액은 숫자여야 합니다.";
        public static final String MONEY_INPUT_NON_THOUSAND_ERROR_MESSAGE = "[ERROR] : 구입 금액은 1000원 단위이어야 합니다.";
        public static final String LOTTO_NUMBER_OVER_RANGE_ERROR_MESSAGE = "[ERROR] : 로또 번호의 범위를 벗어났습니다.";
        public static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] : 로또 번호에 중복 숫자가 없어야 합니다.";
        public static final String LOTTO_WINNING_NUMBER_OVER_RANGE_ERROR_MESSAGE = "[ERROR] : 당첨 번호의 범위를 벗어났습니다.";
        public static final String LOTTO_WINNING_NUMBER_BAD_FORMAT_ERROR_MESSAGE = "[ERROR] : 당첨 번호 형식에 맞지 않습니다.";
        public static final String BONUS_NUMBER_OVER_RANGE_ERROR_MESSAGE = "[ERROR] : 보너스 번호의 범위에 벗어났습니다.";
        public static final String BONUS_NUMBER_BAD_FORMAT_ERROR_MESSAGE = "[ERROR] : 보너스 번호는 숫자만 가능합니다.";
    }

    public class LottoInfo{
        public static final int MIN_RANGE=1;
        public static final int MAX_RANGE=45;
        public static final int COUNT_RANGE=6;

    }

    public class Format{
        public static final String BONUS_NUMBER_FORMAT = "^[1-9]{0,1}[0-9]{1}$";
        public static final String WINNING_NUMBER_FORMAT = "^[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1}\" +\n" +
                "                \",[1-9]{0,1}[0-9]{1},[1-9]{0,1}[0-9]{1}$";
    }
}
