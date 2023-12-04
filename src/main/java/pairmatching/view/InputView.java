package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.model.feature.Feature;
import pairmatching.model.feature.FeatureSet;
import pairmatching.model.program.LevelMissions;
import pairmatching.model.program.Program;

public class InputView {

    public Feature requestSelectFunction() {
        System.out.println("기능을 선택하세요.");
        for (FeatureSet feature : FeatureSet.values()) {
            System.out.println(feature.getNumber() + ". " + feature.getTitle());
        }

        Feature feature;
        try {
            String version = Console.readLine();

            feature = new Feature(version);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return requestSelectFunction();
        }
        return feature;
    }

    public Program requestProgramInformation(List<LevelMissions> initLevelMissions) {
        Program program;
        try {
            System.out.println("과정, 레벨, 미션을 선택하세요.");
            System.out.println("ex) 백엔드, 레벨1, 자동차경주");
            String input = Console.readLine();

            program = Program.from(input, initLevelMissions);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return requestProgramInformation(initLevelMissions);
        }
        return program;
    }
}
