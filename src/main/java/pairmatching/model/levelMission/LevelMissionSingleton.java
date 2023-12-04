package pairmatching.model.levelMission;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import pairmatching.model.level.Level;
import pairmatching.model.mission.Mission;
import pairmatching.model.program.LevelMissions;

public class LevelMissionSingleton {

    private static LevelMissionSingleton instance;
    private final List<LevelMissions> levelMissions;

    private LevelMissionSingleton() {
        levelMissions = initLevelMissions();
    }

    public static LevelMissionSingleton getInstance() {
        if (instance == null) {
            instance = new LevelMissionSingleton();
        }
        return instance;
    }

    public List<LevelMissions> getLevelMissions() {
        return levelMissions;
    }

    private List<LevelMissions> initLevelMissions() {
        LevelMissions level1Missions = new LevelMissions(
            new Level("레벨1"),
            Arrays.asList(new Mission("자동차경주"), new Mission("로또"), new Mission("숫자야구게임")));

        LevelMissions level2Missions = new LevelMissions(
            new Level("레벨2"),
            Arrays.asList(new Mission("장바구니"), new Mission("결제"), new Mission("지하철노선도")));

        LevelMissions level3Missions = new LevelMissions(new Level("레벨3"), Collections.emptyList());

        LevelMissions level4Missions = new LevelMissions(
            new Level("레벨4"), Arrays.asList(new Mission("성능개선"), new Mission("배포")));

        LevelMissions level5Missions = new LevelMissions(new Level("레벨5"), Collections.emptyList());

        return Arrays.asList(level1Missions, level2Missions,
            level3Missions, level4Missions, level5Missions);
    }
}
