package system.insurance.backend.employee;

public enum Authority {
    ADMIN("총 관리자"),
    SALES_ADMIN("영업 관리자"), UNDERWRITING_ADMIN("U/W 관리자"), COMPENSATION_ADMIN("보상 관리자"), DEVELOP_ADMIN("개발 관리자"),
    SALES("영업 담당자"), UNDERWRITING("U/W 담당자"), COMPENSATION("보상 담당자"), DEVELOP("상품 개발자"), EMPLOYEE("사원");

    private final String auth;

    Authority(String auth) {
        this.auth = auth;
    }

    public String getAuth() {
        return auth;
    }
}
