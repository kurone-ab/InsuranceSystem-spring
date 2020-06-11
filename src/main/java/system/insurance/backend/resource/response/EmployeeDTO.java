package system.insurance.backend.resource.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ResponseBody;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmployeeDTO {
    private int id;
    private String name;
    private String auth;

    @Builder
    public EmployeeDTO(int id, String name, String auth) {
        this.id = id;
        this.name = name;
        this.auth = auth;
    }
}