package system.insurance.backend.resource.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseBody;
import system.insurance.backend.insurance.Insurance;
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
    private final Map<String, Long> guaranteeInfos;
    private final List<String> salesTarget;

    @Builder
    public InsuranceDTO(int id, InsuranceType type, InsuranceCompany company, InsuranceStatus status, String name, String author, Date date, Map<String, Long> guaranteeInfos, List<String> salesTarget) {
        this.id = id;
        this.type = type;
        this.company = company;
        this.status = status;
        this.name = name;
        this.author = author;
        this.date = date;
        this.guaranteeInfos = guaranteeInfos;
        this.salesTarget = salesTarget;
    }
}
