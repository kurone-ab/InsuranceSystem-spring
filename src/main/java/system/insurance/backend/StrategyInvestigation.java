package system.insurance.backend;

import lombok.*;
import system.insurance.backend.employee.Employee;
import system.insurance.backend.insurance.Insurance;
import system.insurance.backend.insurance.InsuranceCompany;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "strategy_investigation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class StrategyInvestigation {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn
    private Insurance insurance;
    private String title;
    private Date date;
    @ManyToOne
    @JoinColumn
    private Employee author;

    @Builder
    public StrategyInvestigation(Insurance insurance, String title, Date date, Employee author) {
        this.insurance = insurance;
        this.title = title;
        this.date = date;
        this.author = author;
    }
}
