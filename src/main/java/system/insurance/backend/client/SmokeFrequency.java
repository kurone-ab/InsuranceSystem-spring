package system.insurance.backend.client;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SmokeFrequency {
    NONE("하지 않음"), MS("1달에 1갑 이상"), WS("1주일에 1갑 이상"), DS("1일에 1갑 이상"), DC("1일에 1개비 이상");
    private final String description;
}
