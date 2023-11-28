package pairmatching.model.feature;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.model.levelMission.LevelMissionSingleton;
import pairmatching.model.program.Program;
import pairmatching.model.program.ProgramManager;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingImpl implements FeatureCommand {

    private final ProgramManager programManger;
    private final InputView inputView;
    private final OutputView outputView;

    public PairMatchingImpl(ProgramManager programManger, InputView inputView,
        OutputView outputView) {
        this.programManger = programManger;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void execute() {
        outputView.printProgram(LevelMissionSingleton.getInstance().getLevelMissions());
        Program program = inputView.requestProgramInformation(
            LevelMissionSingleton.getInstance().getLevelMissions());

        // 프로그램에 대한 값이 있는지 없는지에 대한 여부
        if (programManger.containsProgram(program)) {
            System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
            System.out.println("네 | 아니오");
            String input = Console.readLine();
            List<List<String>> teams = programManger.matchingPair(program);
            programManger.rematching(input, program, teams);
        } else {
            List<List<String>> teams = programManger.matchingPair(program);
            programManger.setMatchingResult(program, teams);
            outputView.printPairMatchingResult(teams);
        }

    }

    @Override
    public boolean isApplied(String input) {
        return input.equals("1");
    }
}
