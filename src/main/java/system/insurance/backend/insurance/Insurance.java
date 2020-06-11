package system.insurance.backend.insurance;

import lombok.*;
import system.insurance.backend.employee.Employee;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = EnumType.STRING)
    private InsuranceType type;
    @Enumerated(value = EnumType.STRING)
    private InsuranceStatus status;
    @Enumerated(value = EnumType.STRING)
    private InsuranceCompany company;
    private String name;
    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "author", referencedColumnName = "id")
    private Employee author;
    private Date date;

    @Builder
    public Insurance(InsuranceType type, InsuranceStatus status, InsuranceCompany company, String name, Employee author, Date date) {
        this.type = type;
        this.status = status;
        this.company = company;
        this.name = name;
        this.author = author;
        this.date = date;
    }
}
