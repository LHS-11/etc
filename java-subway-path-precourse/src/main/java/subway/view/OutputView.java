package subway.view;

import java.util.List;

public class OutputView {

    private static final String MAIN_MENU = "## 메인 화면\n" +
            "1. 경로 조회\n" +
            "Q. 종료\n";

    private static final String ROUTE_MENU = "## 경로 기준\n" +
            "1. 최단 거리\n" +
            "2. 최소 시간\n" +
            "B. 돌아가기\n";

    public void printMainMenu(){
        System.out.println(MAIN_MENU);
    }

    public void printRouteMenu(){
        System.out.println(ROUTE_MENU);
    }

    public void printErrorMessage(String message){
        System.out.println(message);
    }
    public void printResult(int distance, int time, List<String> names){
        printResultBoarder();
        printDistanceAmount(distance);
        printTimeAmount(time);
        printResultBoarder();
        printResultName(names);
        printLineBreaking();
    }

    private static void printResultName(List<String> names) {
        names.stream().forEach(s -> System.out.println("[INFO] "+s));
    }

    public void printResultBoarder(){
        System.out.println("[INFO] ---");
    }
    public void printDistanceAmount(int distance){
        System.out.println("[INFO] 총 거리 :"+distance+"km");
    }
    public void printTimeAmount(int time){
        System.out.println("[INFO] 총 소요 시간 :"+time+"분");
    }



    private static void printLineBreaking() {
        System.out.println();
    }
}
