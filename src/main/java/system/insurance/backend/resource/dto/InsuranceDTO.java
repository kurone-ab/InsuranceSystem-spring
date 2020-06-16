package system.insurance.backend.resource.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import system.insurance.backend.insurance.InsuranceCompany;
import system.insurance.backend.insurance.InsuranceStatus;
import system.insurance.backend.insurance.InsuranceType;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InsuranceDTO {
    private final int id;
    private final InsuranceType type;
    private final InsuranceCompany company;
    private final InsuranceStatus status;
    private final String name;
    private final String author;
    private final Date date;
    private final Map<String, Long> guaranteeInfoList;
    private final List<String> salesTargetList;
    private final Map<Integer, String> evaluationReportList;

    @Builder
    public InsuranceDTO(int id, InsuranceType type, InsuranceCompany company, InsuranceStatus status, String name, String author, Date date, Map<String, Long> guaranteeInfos, List<String> salesTarget, Map<String, Long> guaranteeInfoList, List<String> salesTargetList, Map<Integer, String> evaluationReportList) {
        this.id = id;
        this.type = type;
        this.company = company;
        this.status = status;
        this.name = name;
        this.author = author;
        this.date = date;
        this.guaranteeInfoList = guaranteeInfoList;
        this.salesTargetList = salesTargetList;
        this.evaluationReportList = evaluationReportList;
    }
}
