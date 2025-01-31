package pairmatching.model.mission;

public enum MissionSet {
    CAR_RACING("자동차경주"),
    LOTTO("로또"),
    BASEBALL_GAME("숫자야구게임"),
    SHOPPING_CART("장바구니"),
    PAYMENT("결제"),
    SUBWAY_MAP("지하철노선도"),
    PERFORMANCE_IMPROVEMENT("성능개선"),
    DEPLOYMENT("배포");

    private final String name;

    MissionSet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
