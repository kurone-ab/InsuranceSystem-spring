package system.insurance.backend.resource.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StrategyInvestigationDTO {
    private final int insuranceId;
    private final String insurance;
    private final String company;
    private final String title;
    private final Date date;
    private final int authorId;
    private final String author;

    @Builder
    public StrategyInvestigationDTO(int insuranceId, String insurance, String company, String title, Date date, int authorId, String author) {
        this.insuranceId = insuranceId;
        this.insurance = insurance;
        this.company = company;
        this.title = title;
        this.date = date;
        this.authorId = authorId;
        this.author = author;
    }
}
