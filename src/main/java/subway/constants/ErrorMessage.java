package subway.constants;

public enum ErrorMessage {

    FUNCTION_COMMAND_ERROR_MESSAGE("[ERROR] : 메인화면에 존재하는 기능이 아닙니다.");

    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
