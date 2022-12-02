package validation;

public class InputValidator {

    public static void validateFeatureInput(String feature){
        if(isCorrectFeatureFormat(feature)){
            return;
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않는 기능 선택입니다.");
    }

    private static boolean isCorrectFeatureFormat(String feature) {
        return feature.equals("1") || feature.equals("2") || feature.equals("3") || feature.equals("Q");
    }

}
