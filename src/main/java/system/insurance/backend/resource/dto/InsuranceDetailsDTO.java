package system.insurance.backend.resource.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class InsuranceDetailsDTO {
    private final Map<String, Long> guaranteeInfos;
    private final List<String> salesTarget;

    @Builder
    public InsuranceDetailsDTO(Map<String, Long> guaranteeInfos, List<String> salesTarget) {
        this.guaranteeInfos = guaranteeInfos;
        this.salesTarget = salesTarget;
    }
}
