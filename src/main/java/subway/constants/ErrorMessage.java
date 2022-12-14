package subway.constants;

public enum ErrorMessage {

    FUNCTION_COMMAND_ERROR_MESSAGE("[ERROR] : 메인화면에 존재하는 기능이 아닙니다."),
    NAME_SIZE_ERROR_MESSAGE("[ERROR] : 이름은 2글자 이상이어야 합니다."),
    DUPLICATED_NAME_ERROR_MESSAGE("[ERROR] : 중복된 이름입니다."),
    NON_PRESENT_ERROR_MESSAGE("[ERROR] : 존재하지 않습니다.");

    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
