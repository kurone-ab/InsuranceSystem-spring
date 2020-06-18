package system.insurance.backend.client;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Job {
    DRIVER("택배 기사"), HOUSEWIFE("전업 주부"), STUDENT("학생"), SOLDIER("직업 군인"), OFFICE_WORKER("직장인"), SELF_EMPLOYMENT("자영업자"),
    NONE("무직");
    private final String description;
}
