package subway.domain;

import subway.constants.ErrorMessage;

import java.util.regex.Pattern;

import static subway.constants.ErrorMessage.*;

public class Validator {

    public static void validateNameSize(String name){
        if(isCorrectNameSize(name)){
            return;
        }
        throw new IllegalArgumentException(NAME_SIZE_ERROR_MESSAGE.getMessage());
    }

    private static boolean isCorrectNameSize(String name) {
        return name.length() >= 2;
    }


}
