package pairmatching.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import pairmatching.model.course.CourseSet;
import pairmatching.model.program.LevelMissions;
import pairmatching.model.mission.Mission;

public class OutputView {

    public void printProgram(List<LevelMissions> levelMissions) {
        System.out.println("#############################################");
        String courses = Stream.of(CourseSet.values())
            .map(CourseSet::getTitle)
            .collect(Collectors.joining(" | ", "과정: ", ""));
        System.out.println(courses);

        System.out.println("미션:");
        for (LevelMissions levelMission : levelMissions) {
            String missions = levelMission.getMissions().stream()
                .map(Mission::getName)
                .collect(Collectors.joining(" | "));
            System.out.println(
                "  - " + levelMission.getLevel() + ": " + (missions.isEmpty() ? "" : missions));
        }
        System.out.println("#############################################");
    }

    public void printPairMatchingResult(List<List<String>> teams) {
        if (teams.isEmpty()) {
            System.out.println("[ERROR] 매칭 이력이 없습니다.");
            return;
        }

        System.out.println("페어 매칭 결과입니다.");
        for (List<String> team : teams) {
            String teamMembers = String.join(" : ", team);
            System.out.println(teamMembers);
        }
        System.out.println();
    }

    public void printResetMatchingResult() {
        System.out.println("초기화 되었습니다.");
    }
}