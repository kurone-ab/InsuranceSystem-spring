package system.insurance.backend.contract;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import system.insurance.backend.client.Client;
import system.insurance.backend.employee.Employee;
import system.insurance.backend.insurance.Insurance;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Client client;
	@ColumnDefault("0")
	private int payment;
	private Date dueDate;
	@ColumnDefault("false")
	private boolean compensationProvision;
	private String paymentStatus;
	@OneToOne
	@JoinColumn
	private Insurance insurance;
	private Date startDate;
	@OneToOne
	@JoinColumn
	private Employee salesPerson;
	@OneToOne
	@JoinColumn
	private Insurance reinsurance;

	@Builder
	public Contract(int payment, Date dueDate, boolean compensationProvision, String paymentStatus, Insurance insurance, Date startDate, Employee salesPerson, Insurance reinsurance) {
//		this.payment = payment;
		this.dueDate = dueDate;
//		this.compensationProvision = compensationProvision;
		this.paymentStatus = paymentStatus;
		this.insurance = insurance;
		this.startDate = startDate;
		this.salesPerson = salesPerson;
		this.reinsurance = reinsurance;
	}
}
