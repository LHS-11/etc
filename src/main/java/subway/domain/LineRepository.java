package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static subway.constants.ErrorMessage.DUPLICATED_STATION_ERROR_MESSAGE;
import static subway.constants.ErrorMessage.NON_PRESENT_STATION_ERROR_MESSAGE;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }


}
