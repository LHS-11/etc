package chapter9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        ScoreRecord scoreRecord = new ScoreRecord();

        DataSheetView dataSheetView = new DataSheetView(scoreRecord, 5);

        scoreRecord.addDataSheetView(dataSheetView);

        scoreRecord.addDataSheetView(new DataSheetView(scoreRecord,3));

        MinMaxView minMaxView = new MinMaxView(scoreRecord);

        scoreRecord.setMinMaxView(minMaxView);

        for (int index = 0; index <= 5; index++) {
            int score = index * 10;
            System.out.println("Adding " + score);
            scoreRecord.addScore(score);
        }

    }
}
