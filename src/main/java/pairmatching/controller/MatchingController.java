package pairmatching.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pairmatching.model.feature.CheckPairCommandImpl;
import pairmatching.model.feature.Feature;
import pairmatching.model.feature.FeatureCommand;
import pairmatching.model.feature.FeatureManager;
import pairmatching.model.feature.PairMatchingImpl;
import pairmatching.model.feature.ResetPairCommandImpl;
import pairmatching.model.levelMission.LevelMissionSingleton;
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
        LevelMissionSingleton.getInstance();
        ProgramManager programManager = new ProgramManager();

        List<FeatureCommand> featureCommands = Arrays.asList(
            new PairMatchingImpl(programManager, inputView,
                outputView),
            new CheckPairCommandImpl(programManager,
                inputView, outputView),
            new ResetPairCommandImpl(programManager,
                outputView)
        );

        FeatureManager featureManager = new FeatureManager(featureCommands);
        while (true) {
            Feature feature = inputView.requestSelectFunction();

            featureManager.manage(feature.getVersion());

            // 종료
            if (feature.getVersion().equals("Q")) {
                break;
            }
        }
    }
}
