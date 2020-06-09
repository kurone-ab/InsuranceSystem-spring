package system.insurance.backend.resource.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseAnnouncementContent {
    private String content;

    @Builder
    public ResponseAnnouncementContent(String content) {
        this.content = content;
    }
}
