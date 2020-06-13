package system.insurance.backend.resource.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnnouncementDTO {
    private int id;
    private String title;
    private String content;
    private String authorName;
    private Date date;
    private boolean priority;

    @Builder
    public AnnouncementDTO(int id, String title, String content, String authorName, Date date, boolean priority) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorName = authorName;
        this.date = date;
        this.priority = priority;
    }
}
