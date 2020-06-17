package system.insurance.backend.client;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PhysicalFactor {
    private SmokeFrequency smokeFrequency;
    private DrinkingFrequency drinkingFrequency;
}
