package system.insurance.backend.insurance;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum InsuranceType {
    FIRE("화재 보험"), INJURY("상해 보험"), DEATH("사망 보험");

    private final String description;
}
