package subway.domain;

import static subway.constants.ErrorMessage.DUPLICATED_STATION_ERROR_MESSAGE;
import static subway.domain.StationRepository.*;

public class SubwayManager {


    public void addStationRepository(Station station){
        addStation(station);
    }



}
