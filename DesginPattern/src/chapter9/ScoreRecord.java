package chapter9;

import java.util.ArrayList;
import java.util.List;

public class ScoreRecord {
    private List<Integer> scores = new ArrayList<>();
    private List<DataSheetView> dataSheetView = new ArrayList<>();

    private MinMaxView minMaxView;

    public void addDataSheetView(DataSheetView dataSheetView){
        this.dataSheetView.add(dataSheetView);
    }

    public void setMinMaxView(MinMaxView minMaxView){
        this.minMaxView = minMaxView;
    }

    public void addScore(int score){
        scores.add(score);
        for (DataSheetView sheetView : dataSheetView) {
            sheetView.update();
        }
        minMaxView.update();
    }

    public List<Integer> getScores(){
        return scores;
    }
}
