package chapter9.refactor;

public class Client2 {
    public static void main(String[] args) {

        ScoreRecord scoreRecord = new ScoreRecord();
        DataSheetView dataSheetView5 = new DataSheetView(scoreRecord, 5);
        MinMaxView minMaxView = new MinMaxView(scoreRecord);
        scoreRecord.attach(dataSheetView5);
        scoreRecord.attach(minMaxView);
        scoreRecord.addScores(10);
    }
}
