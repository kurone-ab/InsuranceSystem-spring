package system.insurance.backend.insurance;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum InsuranceType {
    CAR("자동차 보험"), DRIVER("운전자 보험"), FIRE("화재 보험"),
    INJURY("상해 보험"), LIABILITY("책임 보험");

    private final String description;
}
