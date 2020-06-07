package system.insurance.backend.resource.reponse;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;


@Getter
@ResponseBody
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseAnnouncementInfo {
    private int id;
    private String title;
    private int authId;
    private String authName;
    private String date;
    private boolean priority;

    @Builder
    public ResponseAnnouncementInfo(int id, String title, int authId, String authName, String date, boolean priority) {
        this.id = id;
        this.title = title;
        this.authId = authId;
        this.authName = authName;
        this.date = date;
        this.priority = priority;
    }
}
