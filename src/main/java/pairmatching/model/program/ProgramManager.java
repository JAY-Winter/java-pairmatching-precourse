package pairmatching.model.program;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.model.course.CourseSet;
import pairmatching.model.level.Level;
import pairmatching.util.FileReaderImpl;

public class ProgramManager {

    // Program 에 따른 매칭 결과를 갖고 있어야함
    private Map<Program, List<List<String>>> matchingResult = new HashMap<>();

    // Program 객체가 맵에 있는지 확인하는 메서드
    public boolean containsProgram(Program program) {
        return matchingResult.containsKey(program);
    }

    // 매칭 결과를 설정하는 메서드
    public void setMatchingResult(Program program, List<List<String>> matchResults) {
        matchingResult.put(program, matchResults);
    }

    public void rematching(String input, Program program, List<List<String>> matchResults) {
        if (input.equals("네")) {
            matchingResult.put(program, matchResults);
        }
    }

    // 매칭 결과를 빈 HashMap 으로 초기화하는 메서드
    public void resetMatchingResults() {
        matchingResult = new HashMap<>();
    }

    // 특정 Program 객체에 대한 매칭 결과를 리턴하는 메서드
    public List<List<String>> getMatchingResultForProgram(Program program) {
        return matchingResult.getOrDefault(program, Collections.emptyList());
    }

    // 매칭 결과를 리턴하는 메서드
    public List<List<String>> matchingPair(Program program) {
        String path = CourseSet.getPathForInput(program.getCourse());
        List<String> names = FileReaderImpl.readAndPrintResourceFile(path);

        int attempts = 0;
        // 3회 시도까지 매칭이 되는지 확인
        while (attempts < 3) {
            List<String> shuffledCrew = Randoms.shuffle(names);
            List<List<String>> teams = new ArrayList<>();
            shuffleCrew(teams, shuffledCrew);

            if (validatePair(teams, program)) {
                return teams;
            }

            attempts++;
        }

        throw new IllegalStateException("[ERROR]유효한 페어를 찾지 못했습니다. 매칭을 다시 시도해주세요.");
    }

    // 같은 레벨에서 페어로 만난 적이 있는지 확인
    private boolean validatePair(List<List<String>> pairs, Program program) {
        List<List<String>> previousMatchingResults = getMatchingResultsByLevel(program.getLevel());

        for (List<String> currentPair : pairs) {
            for (List<String> previousPair : previousMatchingResults) {
                if (isPairMatchedBefore(currentPair, previousPair)) {
                    return false;
                }
            }
        }

        return true;
    }

    // 특정 Level에 대한 모든 Program의 매칭 결과를 찾는 메서드
    public List<List<String>> getMatchingResultsByLevel(Level level) {
        List<List<String>> results = new ArrayList<>();
        for (Map.Entry<Program, List<List<String>>> entry : matchingResult.entrySet()) {
            Program program = entry.getKey();
            if (program.getLevel().equals(level)) {
                results.addAll(entry.getValue());
            }
        }
        return results;
    }

    // 두 페어가 동일한지 확인하는 메소드
    private boolean isPairMatchedBefore(List<String> pair1, List<String> pair2) {
        return pair1.containsAll(pair2) && pair2.containsAll(pair1);
    }


    private static void shuffleCrew(List<List<String>> teams, List<String> shuffledCrew) {
        for (int i = 0; i < shuffledCrew.size(); i += 2) {
            // 마지막에 3명이 남는 경우
            if (i + 3 == shuffledCrew.size()) {
                teams.add(shuffledCrew.subList(i, i + 3));
                break; // 반복문 종료
            } else {
                teams.add(shuffledCrew.subList(i, i + 2));
            }
        }
    }

    public Map<Program, List<List<String>>> getMatchingResult() {
        return matchingResult;
    }
}
