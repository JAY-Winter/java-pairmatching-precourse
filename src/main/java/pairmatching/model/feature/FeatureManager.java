package pairmatching.model.feature;

import java.util.List;

public class FeatureManager {

    private final List<FeatureCommand> featureCommands;

    public FeatureManager(List<FeatureCommand> featureCommands) {
        this.featureCommands = featureCommands;
    }

    public void manage(String input) {
        featureCommands.stream()
            .filter(featureCommand -> featureCommand.isApplied(input))
            .findFirst()
            .ifPresent(FeatureCommand::execute);
    }
}
