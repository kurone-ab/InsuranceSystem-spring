package system.insurance.backend.resource.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarketInvestigationDTO {
    private final String title;
    private final Date date;
    private final int authorId;
    private final String author;
    private final String needs;
    private final String targetClient;

    @Builder
    public MarketInvestigationDTO(String title, Date date, int authorId, String author, String needs, String targetClient) {
        this.title = title;
        this.date = date;
        this.authorId = authorId;
        this.author = author;
        this.needs = needs;
        this.targetClient = targetClient;
    }
}
