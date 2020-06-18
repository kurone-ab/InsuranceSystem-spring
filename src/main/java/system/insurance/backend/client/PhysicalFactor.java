package system.insurance.backend.client;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PhysicalFactor {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private SmokeFrequency smokeFrequency;
    @Enumerated(EnumType.STRING)
    private DrinkingFrequency drinkingFrequency;

    @Builder
    public PhysicalFactor(SmokeFrequency smokeFrequency, DrinkingFrequency drinkingFrequency) {
        this.smokeFrequency = smokeFrequency;
        this.drinkingFrequency = drinkingFrequency;
    }
}
