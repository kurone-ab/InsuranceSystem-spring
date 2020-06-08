package system.insurance.backend.contract;

public enum InsuranceCo {
    kyobo("교보생명"), db("DB손해보험"), meritz("메리츠화재"), samsungLife("삼성생명"),
    samsungFire("삼성화재"), own("신동아화재");

    private final String title;

    InsuranceCo(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
