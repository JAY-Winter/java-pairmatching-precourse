package pairmatching.model.feature;

public enum FeatureSet {
    MATHCHING("페어 매칭", "1"),
    CHECK("페어 조회", "2"),
    RESET("페어 초기화", "3"),
    EXIT("종료", "Q");

    private String title;
    private String number;

    public String getTitle() {
        return title;
    }

    public String getNumber() {
        return number;
    }

    FeatureSet(String title, String number) {
        this.title = title;
        this.number = number;
    }
}
