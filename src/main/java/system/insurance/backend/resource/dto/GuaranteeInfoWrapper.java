package system.insurance.backend.resource.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GuaranteeInfoWrapper {
    private final long limit;
    private final String condition;
    private final boolean special;

    @Builder
    public GuaranteeInfoWrapper(long limit, String condition, boolean special) {
        this.limit = limit;
        this.condition = condition;
        this.special = special;
    }
}
