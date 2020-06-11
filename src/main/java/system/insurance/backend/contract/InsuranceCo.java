package system.insurance.backend.contract;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum InsuranceCo {
    KYOBO("교보생명"), DB("DB손해보험"), MERITZ("메리츠화재"), SAMSUNG_LIFE("삼성생명"),
    SAMSUNG_FIRE("삼성화재"), OWN("신동아화재");

    private final String description;
}
