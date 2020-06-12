package system.insurance.backend.insurance;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "sales_target")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class SalesTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(targetEntity = Insurance.class)
    @JoinColumn(name = "insurance_id", referencedColumnName = "id")
    private Insurance insurance;
    private String target;

    @Builder
    public SalesTarget(Insurance insurance, String target) {
        this.insurance = insurance;
        this.target = target;
    }
}
