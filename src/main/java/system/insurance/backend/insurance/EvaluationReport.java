package system.insurance.backend.insurance;

import lombok.*;
import system.insurance.backend.employee.Employee;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "evaluation_report")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EvaluationReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String path;
    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "author", referencedColumnName = "id")
    private Employee author;
    @ManyToOne(targetEntity = Insurance.class)
    @JoinColumn(name = "insurance", referencedColumnName = "id")
    private Insurance insurance;
    private Date date;

    @Builder
    public EvaluationReport(String path, Employee author, Insurance insurance, Date date) {
        this.path = path;
        this.author = author;
        this.insurance = insurance;
        this.date = date;
    }
}
