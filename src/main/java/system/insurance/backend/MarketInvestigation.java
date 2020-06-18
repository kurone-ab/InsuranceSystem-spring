package system.insurance.backend;

import lombok.*;
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

    @Builder
    public MarketInvestigation(String title, Date date, Employee author, String needs, String targetClient) {
        this.title = title;
        this.date = date;
        this.author = author;
        this.needs = needs;
        this.targetClient = targetClient;
    }
}
