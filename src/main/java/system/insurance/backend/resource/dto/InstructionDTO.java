package system.insurance.backend.resource.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstructionDTO {
    private final int id;
    private final String title;
    private final String instruction;
    private final int authorId;
    private final String author;
    private final Date date;

    @Builder
    public InstructionDTO(int id, String title, String instruction, int authorId, String author, Date date) {
        this.id = id;
        this.title = title;
        this.instruction = instruction;
        this.authorId = authorId;
        this.author = author;
        this.date = date;
    }
}
