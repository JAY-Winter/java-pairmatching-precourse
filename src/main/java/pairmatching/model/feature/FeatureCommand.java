package pairmatching.model.feature;

public interface FeatureCommand {

    void execute();

    boolean isApplied(String input);
}
