package subway.view;

public class OutputView {

    private static final String MAIN_MENU = "## 메인 화면\n" +
            "1. 경로 조회\n" +
            "Q. 종료\n";

    private static final String ROUTE_MENU = "## 경로 기준\n" +
            "1. 최단 거리\n" +
            "2. 최소 시간\n" +
            "B. 돌아가기";

    private static final String START_STATION = "## 출발역을 입력하세요.";
    private static final String END_STATION = "## 도착역을 입력하세요.";

    public void printMainMenu(){
        System.out.println(MAIN_MENU);
    }

    public void printRouteMenu(){
        System.out.println(ROUTE_MENU);
    }

    public void printStartStation(){
        System.out.println(START_STATION);
    }

    public void printEndStation(){
        System.out.println(END_STATION);
    }

    public void printErrorMessage(String message){
        System.out.println(message);
    }
}
