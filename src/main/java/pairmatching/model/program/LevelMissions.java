package pairmatching.model.mission;

import java.util.List;

public class LevelMissions {

    public String getLevelName() {
        return levelName;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    private final String levelName;
    private final List<Mission> missions;

    public LevelMissions(String levelName, List<Mission> missions) {
        this.levelName = levelName;
        this.missions = missions;
    }
}
