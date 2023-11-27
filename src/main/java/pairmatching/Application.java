package pairmatching;

import pairmatching.controller.MatchingController;
import pairmatching.view.InputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        MatchingController matchingController = new MatchingController(inputView);
        matchingController.run();
    }
}
