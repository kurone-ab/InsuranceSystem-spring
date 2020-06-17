package system.insurance.backend.client;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FinancialFactor {
    private long income;
    private long property;
    private int creditRating;
}
