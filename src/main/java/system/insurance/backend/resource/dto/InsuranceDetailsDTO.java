package system.insurance.backend.resource.dto;

import lombok.Builder;
import lombok.Getter;
import system.insurance.backend.insurance.InsuranceType;

import java.util.List;
import java.util.Map;

@Getter
public class InsuranceDetailsDTO {
    private final int id;
    private final String name;
    private final InsuranceType type;
    private final Map<String, Long> guaranteeInfoList;
    private final List<String> salesTargetList;

    @Builder
    public InsuranceDetailsDTO(int id, String name, InsuranceType type, Map<String, Long> guaranteeInfoList, List<String> salesTargetList) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.guaranteeInfoList = guaranteeInfoList;
        this.salesTargetList = salesTargetList;
    }
}
