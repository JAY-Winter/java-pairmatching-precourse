package pairmatching.model.feature;

import pairmatching.model.levelMission.LevelMissionSingleton;
import pairmatching.model.program.Program;
import pairmatching.model.program.ProgramManager;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class CheckPairCommandImpl implements FeatureCommand {

    private final ProgramManager programManager;
    private final InputView inputView;
    private final OutputView outputView;

    public CheckPairCommandImpl(ProgramManager programManager, InputView inputView,
        OutputView outputView) {
        this.programManager = programManager;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void execute() {
        Program program = inputView.requestProgramInformation(
            LevelMissionSingleton.getInstance().getLevelMissions());
        outputView.printPairMatchingResult(
            programManager.getMatchingResultForProgram(program));
    }

    @Override
    public boolean isApplied(String input) {
        return input.equals("2");
    }
}
