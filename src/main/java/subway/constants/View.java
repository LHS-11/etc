package subway.constants;

public enum View {

    MAIN_VIEW_MESSAGE("## 메인 화면\n" +
            "1. 역 관리\n" +
            "2. 노선 관리\n" +
            "3. 구간 관리\n" +
            "4. 지하철 노선도 출력\n" +
            "Q. 종료\n"),
    FUNCTION_MESSAGE("## 원하는 기능을 선택하세요."),
    STATION_VIEW_MESSAGE("## 역 관리 화면\n" +
            "1. 역 등록\n" +
            "2. 역 삭제\n" +
            "3. 역 조회\n" +
            "B. 돌아가기\n"),
    REGISTER_STATION_MESSAGE("## 등록할 역 이름을 입력하세요."),
    REMOVE_STATION_MESSAGE("## 삭제할 역 이름을 입력하세요."),
    STATION_REGISTRATION_SUCCESS_MESSAGE("[INFO] 지하철 역이 등록되었습니다."),
    STATION_REMOVING_SUCCESS_MESSAGE("[INFO] 구간이 삭제되었습니다."),
    STATION_LIST_MESSAGE("## 역 목록"),

    LINE_VIEW_MESSAGE("## 노선 관리 화면\n" +
            "1. 노선 등록\n" +
            "2. 노선 삭제\n" +
            "3. 노선 조회\n" +
            "B. 돌아가기"),

    REGISTER_LINE_MESSAGE("## 등록할 노선 이름을 입력하세요."),

    REGISTER_UP_BOUND_STATION_MESSAGE("## 등록할 노선의 상행 종점역 이름을 입력하세요."),
    REGISTER_DOWN_BOUND_STATION_MESSAGE("## 등록할 노선의 하행 종점역 이름을 입력하세요."),
    LINE_REMOVING_SUCCESS_MESSAGE("[INFO] 지하철 노선이 삭제되었습니다."),
    REMOVE_LINE_MESSAGE("## 삭제할 노선 이름을 입력하세요.");






    private String message;

    View(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
