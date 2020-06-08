package system.insurance.backend.resource.reponse;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseEmployee {
    private int id;
    private String name;
    private String auth;

    @Builder
    public ResponseEmployee(int id, String name, String auth) {
        this.id = id;
        this.name = name;
        this.auth = auth;
    }
}