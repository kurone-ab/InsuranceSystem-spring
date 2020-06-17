package system.insurance.backend.contract;

import lombok.*;
import system.insurance.backend.employee.Employee;
import system.insurance.backend.insurance.Insurance;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	private int clientId;
//	private int payment;
	private Date dueDate;
//	private boolean compensationProvision;
	private String paymentStatus;
	@ManyToOne(targetEntity = Insurance.class)
	@JoinColumn(name = "insurance_id", referencedColumnName = "id")
	private Insurance insurance;
	private Date startDate;
	@ManyToOne(targetEntity = Employee.class)
	@JoinColumn(name = "sales_person_id", referencedColumnName = "id")
	private Employee salesPerson;
	@ManyToOne(targetEntity = Insurance.class)
	@JoinColumn(name = "reinsurance_id", referencedColumnName = "id")
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
