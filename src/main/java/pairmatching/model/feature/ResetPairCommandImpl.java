package pairmatching.model.feature;

import pairmatching.model.program.ProgramManager;
import pairmatching.view.OutputView;

public class ResetPairCommandImpl implements FeatureCommand {

    private final ProgramManager programManager;
    private final OutputView outputView;

    public ResetPairCommandImpl(ProgramManager programManager, OutputView outputView) {
        this.programManager = programManager;
        this.outputView = outputView;
    }

    @Override
    public void execute() {
        programManager.resetMatchingResults();
        outputView.printResetMatchingResult();
    }

    @Override
    public boolean isApplied(String input) {
        return input.equals("3");
    }
}
