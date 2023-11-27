package pairmatching.model.program;

import java.util.List;
import pairmatching.model.level.Level;
import pairmatching.model.mission.Mission;

public class LevelMissions {

    private final Level level;

    private final List<Mission> missions;

    public LevelMissions(Level level, List<Mission> missions) {
        this.level = level;
        this.missions = missions;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public String getLevel() {
        return level.getName();
    }
}