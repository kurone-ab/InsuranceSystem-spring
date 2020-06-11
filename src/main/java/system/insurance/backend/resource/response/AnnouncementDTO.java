package system.insurance.backend.resource.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AnnouncementDTO {
    private int id;
    private String title;
    private String content;
    private int authorId;
    private String authorName;
    private String date;
    private boolean priority;

    @Builder
    public AnnouncementDTO(int id, String title, String content, int authorId, String authorName, String date, boolean priority) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.authorName = authorName;
        this.date = date;
        this.priority = priority;
    }
}
