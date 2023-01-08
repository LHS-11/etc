package org.example;

public class PasswordValidator {

    private static final String WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE = "비밀번호는 최소 8자 이상 12자 이하여야 합니다.";
    public static void validate(String password) {
        if(isCorrectPassword(password)){
            return;
        }
        throw new IllegalArgumentException(WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
    }

    private static boolean isCorrectPassword(String password) {
        int length = password.length();
        return length >= 8 && length <= 12;
    }
}
