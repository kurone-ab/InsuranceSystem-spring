package system.insurance.backend;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import system.insurance.backend.employee.Employee;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "market_investigation")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class MarketInvestigation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private Date date;
    @ManyToOne
    @JoinColumn
    private Employee author;
    @Column(columnDefinition = "text")
    private String needs;
    @Column(length = 500)
    private String targetClient;
}
