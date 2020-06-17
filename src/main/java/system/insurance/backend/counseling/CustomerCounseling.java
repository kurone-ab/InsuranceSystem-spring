package system.insurance.backend.counseling;

import lombok.Builder;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import system.insurance.backend.employee.Employee;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "customer_counseling")
public class CustomerCounseling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "counselor_id", referencedColumnName = "id")
    private Employee counselor;
    private String content;
    private Date date;

    @Builder
    public CustomerCounseling(Employee counselor, String content, Date date) {
        this.counselor = counselor;
        this.content = content;
        this.date = date;
    }
}
