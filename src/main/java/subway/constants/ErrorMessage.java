package subway.constants;

public enum ErrorMessage {

    COMMAND_INPUT_ERROR_MESSAGE("[ERROR] : 문자를 잘못 입력하셨습니다.\n");


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
