package pairmatching.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import pairmatching.model.feature.Feature;
import pairmatching.model.level.Level;
import pairmatching.model.mission.Mission;
import pairmatching.model.program.LevelMissions;
import pairmatching.model.program.Program;
import pairmatching.model.program.ProgramManager;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {

    private final InputView inputView;
    private final OutputView outputView;

    public MatchingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void run() {
        ProgramManager programManager = new ProgramManager();

        while (true) {
            // 레벨 별 맞는 미션을 선택해야함 -> 검증 추가 필요
            Feature feature = inputView.requestSelectFunction();

            // 페어 매칭
            if (feature.getVersion().equals("1")) {
                // LevelMissions 싱글톤으로 운용해도 될 듯
                outputView.printProgram(initLevelMissions());
                Program program = inputView.requestProgramInformation(
                    initLevelMissions());

                // 프로그램에 대한 값이 있는지 없는지에 대한 여부
                if (programManager.containsProgram(program)) {
                    System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
                    System.out.println("네 | 아니오");
                    String input = Console.readLine();
                    List<List<String>> teams = programManager.matchingPair(program);
                    programManager.rematching(input, program, teams);
                } else {
                    List<List<String>> teams = programManager.matchingPair(program);
                    programManager.setMatchingResult(program, teams);
                    outputView.printPairMatchingResult(teams);
                }
            }

            // 페어 조회
            if (feature.getVersion().equals("2")) {
                Program program = inputView.requestProgramInformation(
                    initLevelMissions());
                outputView.printPairMatchingResult(
                    programManager.getMatchingResultForProgram(program));
            }

            // 페어 초기화
            if (feature.getVersion().equals("3")) {
                programManager.resetMatchingResults();
                outputView.printResetMatchingResult();
            }

            // 종료
            if (feature.getVersion().equals("Q")) {
                break;
            }
        }
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
