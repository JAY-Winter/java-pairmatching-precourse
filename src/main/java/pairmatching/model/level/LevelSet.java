package pairmatching.model.level;

public enum LevelSet {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5"),
    ;

    public String getName() {
        return name;
    }

    private final String name;

    LevelSet(String name) {
        this.name = name;
    }
}
