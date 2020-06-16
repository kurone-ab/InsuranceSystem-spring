package system.insurance.backend.resource.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
UserDTOtructor(access = AccessLevel.PROTECTED)
public class UserDTO {
    private int id;
    private String name;
    private String auth;

    @Builder
    public UserDTO(int id, String name, String auth) {
        this.id = id;
        this.name = name;
        this.auth = auth;
    }
}