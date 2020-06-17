package system.insurance.backend.client;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum DrinkingFrequency {
    NONE("하지 않음"), YC("1년에 1번 이상"), SMC("6개월에 1번 이상"), TMC("3개월에 1번 이상"), OMC("1개월에 1번 이상");
    private final String description;
}
