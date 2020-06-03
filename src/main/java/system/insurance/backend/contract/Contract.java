package system.insurance.backend.contract;

import system.insurance.backend.employee.SalesPerson;

import java.util.ArrayList;
import java.util.Date;

public class Contract {
	private int id;
	private int clientId;
	private int paymentAmount;
	private ArrayList<JointAcquisition_Info> jointAcquisition; // �����μ�
	private Date dueDate;
	private boolean payInStatus;
	private boolean payOutStatus;
	private int insuranceId;
	private double lossRate;
	private Date startDate;
	private SalesPerson salesPerson;
	private int reinsuranceInfo;

	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Contract)) return false;

		Contract contract = (Contract) o;

		return id == contract.id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public ArrayList<JointAcquisition_Info> getJointAcquisition() {
		return jointAcquisition;
	}

	public void setJointAcquisition(ArrayList<JointAcquisition_Info> jointAcquisition) {
		this.jointAcquisition = jointAcquisition;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isPayInStatus() {
		return payInStatus;
	}

	public void setPayInStatus(boolean payInStatus) {
		this.payInStatus = payInStatus;
	}

	public boolean isPayOutStatus() {
		return payOutStatus;
	}

	public void setPayOutStatus(boolean payOutStatus) {
		this.payOutStatus = payOutStatus;
	}

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

	public double getLossRate() {
		return lossRate;
	}

	public void setLossRate(double lossRate) {
		this.lossRate = lossRate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public SalesPerson getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(SalesPerson salesPerson) {
		this.salesPerson = salesPerson;
	}

	public int getReinsuranceInfo() {
		return reinsuranceInfo;
	}

	public void setReinsuranceInfo(int reinsuranceInfo) {
		this.reinsuranceInfo = reinsuranceInfo;
	}

	public static class JointAcquisition_Info {
		private int id;
		private double equityRatio;
		private InsuranceCo insuranceCo;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public double getEquityRatio() {
			return equityRatio;
		}

		public void setEquityRatio(double equityRatio) {
			this.equityRatio = equityRatio;
		}

		public InsuranceCo getInsuranceCo() {
			return insuranceCo;
		}

		public void setInsuranceCo(InsuranceCo insuranceCo) {
			this.insuranceCo = insuranceCo;
		}
	}


}
