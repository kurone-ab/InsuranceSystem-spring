package system.insurance.backend.resource.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AnnouncementDTO {
    private int id;
    private String title;
    private String content;
    private int authorId;
    private String authorName;
    private Date date;
    private boolean priority;

    @Builder
    public AnnouncementDTO(int id, String title, String content, int authorId, String authorName, Date date, boolean priority) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.authorName = authorName;
        this.date = date;
        this.priority = priority;
    }
}
