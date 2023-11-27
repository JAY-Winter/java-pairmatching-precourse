package pairmatching.controller;

import pairmatching.model.feature.Feature;
import pairmatching.view.InputView;

public class MatchingController {

    private final InputView inputView;

    public MatchingController(InputView inputView) {
        this.inputView = inputView;
    }


    public void run() {
        inputView.requestSelectFunction();
    }

}
