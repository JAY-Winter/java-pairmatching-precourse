package pairmatching.model.program;

import java.util.List;
import java.util.Objects;
import pairmatching.model.course.Course;
import pairmatching.model.level.Level;
import pairmatching.model.mission.Mission;

public class Program {

    private final Course course;
    private final Level level;
    private final Mission mission;

    public Program(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public static Program from(String input, List<LevelMissions> initLevelMissions) {
        validateInvalid(input);

        String[] parts = input.split(",");
        String courseName = parts[0].trim();
        String levelName = parts[1].trim();
        String missionName = parts[2].trim();

        isMissionInLevel(levelName, missionName, initLevelMissions);

        Course course = new Course(courseName); // 가정: Course, Level, Mission 객체 생성 방법
        Level level = new Level(levelName);
        Mission mission = new Mission(missionName);

        return new Program(course, level, mission);
    }

    private static void validateInvalid(String input) {
        String pattern = "([\\w가-힣]+),\\s*([\\w가-힣]+),\\s*([\\w가-힣]+)";
        if (!input.matches(pattern)) {
            throw new IllegalArgumentException("[ERROR] 올바른 프로그램을 입력해주세요.");
        }
    }

    private static void isMissionInLevel(String level, String mission,
        List<LevelMissions> initLevelMissions) {
        Mission missionToCheck = new Mission(mission);

        for (LevelMissions lm : initLevelMissions) {
            if (level.equals(lm.getLevel())) {
                if (!lm.getMissions().contains(missionToCheck)) {
                    throw new IllegalArgumentException("[ERROR] 레벨에 맞는 미션을 입력하세요.");
                }
            }
        }
    }


    public String getCourse() {
        return course.getTitle();
    }

    public Level getLevel() {
        return level;
    }

    public String getMission() {
        return mission.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Program program = (Program) o;
        return Objects.equals(course, program.course) &&
            Objects.equals(level, program.level) &&
            Objects.equals(mission, program.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }
}
