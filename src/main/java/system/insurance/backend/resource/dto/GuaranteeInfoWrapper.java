package system.insurance.backend.resource.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GuaranteeInfoWrapper {
    private final long limit;
    private final String condition;

    @Builder
    public GuaranteeInfoWrapper(long limit, String condition) {
        this.limit = limit;
        this.condition = condition;
    }
}
