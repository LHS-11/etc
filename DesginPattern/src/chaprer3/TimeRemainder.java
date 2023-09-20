package chaprer3;

import java.util.Calendar;

public class TimeRemainder {

    private TimeProvider timeProvider;
    private MP3 m = new MP3();

    public void setTimeProvider(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    public void remainder(){

        int hour = timeProvider.getTime();

        if(hour>=22){
            m.playSong();
        }
    }
}
