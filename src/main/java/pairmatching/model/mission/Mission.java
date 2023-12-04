package pairmatching.model.mission;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mission mission = (Mission) o;
        return Objects.equals(name, mission.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    @Override
    public String toString() {
        return name;
    }
}
