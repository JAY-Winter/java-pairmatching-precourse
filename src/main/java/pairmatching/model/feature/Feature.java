package pairmatching.model.feature;

import java.util.ArrayList;
import java.util.List;

public class Feature {

    private final String version;

    public Feature(String version) {
        validate(version);
        this.version = version;
    }

    private void validate(String version) {
        validateInvalidVersion(version);
    }

    private static void validateInvalidVersion(String version) {
        List<String> versions = new ArrayList<>();
        for (FeatureSet featureSet : FeatureSet.values()) {
            versions.add(featureSet.getNumber());
        }
        if (!versions.contains(version)) {
            throw new IllegalArgumentException("[ERROR] 올바른 기능을 입력해주세요.");
        }
    }
}
