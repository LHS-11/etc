package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static subway.constants.ErrorMessage.DUPLICATED_NAME_ERROR_MESSAGE;
import static subway.constants.ErrorMessage.NON_PRESENT_ERROR_MESSAGE;

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

    public static void validateDuplicateLine(Line line){
        if(isPresentLine(line)){
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR_MESSAGE.getMessage());
        }
    }
    public static void validatePresentLine(Line line){
        if(!isPresentLine(line)){
            throw new IllegalArgumentException(NON_PRESENT_ERROR_MESSAGE.getMessage());
        }
    }
    public static boolean isPresentLine(Line line) {
        return lines.stream().anyMatch(l-> l.isSameLine(line));
    }
}
