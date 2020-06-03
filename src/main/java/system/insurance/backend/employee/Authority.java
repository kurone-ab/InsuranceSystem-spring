package system.insurance.backend.employee;

public enum Authority {
    admin("총 관리자"),
    salesAdmin("영업 관리자"), underwritingAdmin("U/W 관리자"), compensationAdmin("보상 관리자"), developAdmin("개발 관리자"),
    sales("영업 담당자"), underwriting("U/W 담당자"), compensation("보상 담당자"), develop("상품 개발자"), employee("사원");

    private final String auth;

    Authority(String auth) {
        this.auth = auth;
    }

    public String getAuth() {
        return auth;
    }
}
