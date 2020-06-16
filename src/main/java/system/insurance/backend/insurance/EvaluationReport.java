package system.insurance.backend.insurance;

import lombok.Getter;
import lombok.Setter;
import system.insurance.backend.employee.Employee;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "evaluation_report")
@Getter
@Setter
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
}
