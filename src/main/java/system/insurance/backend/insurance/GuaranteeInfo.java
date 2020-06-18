package system.insurance.backend.insurance;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "guarantee_info")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GuaranteeInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(targetEntity = Insurance.class)
    @JoinColumn(name = "insurance_id", referencedColumnName = "id")
    private Insurance insurance;
    private long guaranteeLimit;
    @Column(columnDefinition = "text")
    private String guaranteeCondition;
    private boolean specialCondition;
    private long guaranteeFare;

    @Builder
    public GuaranteeInfo(Insurance insurance, long guaranteeLimit, String guaranteeCondition, boolean specialCondition, long guaranteeFare) {
        this.insurance = insurance;
        this.guaranteeLimit = guaranteeLimit;
        this.guaranteeCondition = guaranteeCondition;
        this.specialCondition = specialCondition;
        this.guaranteeFare = guaranteeFare;
    }
}
