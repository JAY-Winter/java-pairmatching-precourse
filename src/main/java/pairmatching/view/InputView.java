package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;
import pairmatching.model.feature.Feature;
import pairmatching.model.feature.FeatureSet;

public class InputView {


    public Feature requestSelectFunction() {
        System.out.println("기능을 선택하세요.");
        for (FeatureSet feature : FeatureSet.values()) {
            System.out.println(feature.getNumber() + ". " + feature.getTitle());
        }

        Feature feature;
        try {
//            String version = Console.readLine();
            String version = new Scanner(System.in).nextLine();

            feature = new Feature(version);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return requestSelectFunction();
        }
        return feature;
    }
}
