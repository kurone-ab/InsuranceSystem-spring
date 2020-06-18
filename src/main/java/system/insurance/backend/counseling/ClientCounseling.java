package system.insurance.backend.counseling;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import system.insurance.backend.client.Client;
import system.insurance.backend.employee.Employee;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "client_counseling")
public class ClientCounseling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "counselor_id", referencedColumnName = "id")
    private Employee counselor;
    private String content;
    private Date date;

    @Builder
    public ClientCounseling(Employee counselor, String content, Date date) {
        this.counselor = counselor;
        this.content = content;
        this.date = date;
    }
}
