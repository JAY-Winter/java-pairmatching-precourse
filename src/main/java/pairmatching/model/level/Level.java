package pairmatching.model.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Level {

    private final String name;

    public Level(String name) {
        validateInvalidLevel(name);

        this.name = name;
    }

    private static void validateInvalidLevel(String name) {
        List<String> levels = new ArrayList<>();
        for (LevelSet levelSet : LevelSet.values()) {
            levels.add(levelSet.getName());
        }

        if (!levels.contains(name.trim())) {
            throw new IllegalArgumentException("[ERROR] 올바른 레벨 정보를 입력해주세요.");
        }
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Level level = (Level) o;
        return Objects.equals(name, level.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
