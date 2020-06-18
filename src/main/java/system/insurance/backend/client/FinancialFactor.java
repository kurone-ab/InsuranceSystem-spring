package system.insurance.backend.client;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FinancialFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long income;
    private long property;
    private int creditRating;

    public FinancialFactor(long income, long property, int creditRating) {
        this.income = income;
        this.property = property;
        this.creditRating = creditRating;
    }
}
