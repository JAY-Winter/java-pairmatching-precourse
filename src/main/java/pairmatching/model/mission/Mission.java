package pairmatching.model.program;

import java.util.ArrayList;
import java.util.List;

public class Mission {

    private final String name;

    public Mission(String name) {
        validateInvalid(name);

        this.name = name;
    }

    private static void validateInvalid(String name) {
        List<String> missions = new ArrayList<>();
        for (MissionSet missionSet : MissionSet.values()) {
            missions.add(missionSet.getName());
        }

        if (!missions.contains(name.trim())) {
            throw new IllegalArgumentException("[ERROR] 올바른 미션명을 입력해주세요.");
        }
    }

    public String getName() {
        return name;
    }
}
