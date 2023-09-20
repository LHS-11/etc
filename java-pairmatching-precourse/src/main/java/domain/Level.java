package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")){
         public void add(List<String> crewPairInfo){
            levelOneCrewPairInfo.add(crewPairInfo);
        }

        @Override
        public List<List<String>> getCrewPairInfo() {
            return levelOneCrewPairInfo;
        }

    },
    LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")){
        @Override
        public void add(List<String> crewPairInfo) {
            levelTwoCrewPairInfo.add(crewPairInfo);
        }

        @Override
        public List<List<String>> getCrewPairInfo() {
            return levelTwoCrewPairInfo;
        }
    },
    LEVEL3("레벨3", Collections.emptyList()){
        @Override
        public void add(List<String> crewPairInfo) {
            levelTwoCrewPairInfo.add(crewPairInfo);
        }

        @Override
        public List<List<String>> getCrewPairInfo() {
            return levelThreeCrewPairInfo;
        }
    },
    LEVEL4("레벨4", Arrays.asList("성능개선", "배포")){
        @Override
        public void add(List<String> crewPairInfo) {
            levelThreeCrewPairInfo.add(crewPairInfo);
        }

        @Override
        public List<List<String>> getCrewPairInfo() {
            return levelFourCrewPairInfo;
        }
    },
    LEVEL5("레벨5", Collections.emptyList()){
        @Override
        public void add(List<String> crewPairInfo) {
            levelFourCrewPairInfo.add(crewPairInfo);
        }

        @Override
        public List<List<String>> getCrewPairInfo() {
            return levelFiveCrewPairInfo;
        }
    },
    EMPTY("없음", Collections.emptyList()){
        @Override
        public void add(List<String> crewPairInfo) {
            levelFiveCrewPairInfo.add(crewPairInfo);
        }

        @Override
        public List<List<String>> getCrewPairInfo() {
            return null;
        }

    };

    private String name;
    private List<String> missions;
    private static List<List<String>> levelOneCrewPairInfo = new ArrayList<>();
    private static List<List<String>> levelTwoCrewPairInfo=new ArrayList<>();
    private static List<List<String>> levelThreeCrewPairInfo = new ArrayList<>();
    private static List<List<String>> levelFourCrewPairInfo = new ArrayList<>();
    private static List<List<String>> levelFiveCrewPairInfo = new ArrayList<>();

    public static List<List<String>> getLevelOneCrewPairInfo() {
        return levelOneCrewPairInfo;
    }

    public abstract void add(List<String> crewPairInfo);

    public abstract List<List<String>> getCrewPairInfo();

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }


    public static Level findLevel(String levelName) {
        return Arrays.stream(Level.values())
                .filter(l->l.name.equals(levelName))
                .filter(l -> l.name.equals(levelName))
                .findAny()
                .orElse(EMPTY);
    }

    public static boolean isCorrectMission(String mission) {
        return Arrays.stream(Level.values())
                .filter(level -> level.hasMission(mission))
                .findAny()
                .isPresent();
    }

    public boolean hasMission(String mission) {
        return missions.stream()
                .anyMatch(m -> m.equals(mission));
    }

    public void initCrewPair(){
        levelOneCrewPairInfo = new ArrayList<>();
        levelTwoCrewPairInfo=new ArrayList<>();
        levelThreeCrewPairInfo = new ArrayList<>();
        levelFourCrewPairInfo = new ArrayList<>();
        levelFiveCrewPairInfo = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
}
