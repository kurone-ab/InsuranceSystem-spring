package system.insurance.backend.resource.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GuaranteeInfoWrapper {
    private final long limit;
    private final String condition;

    @Builder
    public GuaranteeInfoWrapper(long limit, String condition) {
        this.limit = limit;
        this.condition = condition;
    }
}
