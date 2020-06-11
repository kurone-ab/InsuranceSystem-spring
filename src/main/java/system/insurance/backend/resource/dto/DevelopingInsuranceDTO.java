package system.insurance.backend.resource.dto;

import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Getter
public class DevelopingInsuranceDTO {
    private final int id;
    private final String name;
    private final String author;
    private final Date date;

    @Builder
    public DevelopingInsuranceDTO(int id, String name, Date date, String author) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.author = author;
    }
}
