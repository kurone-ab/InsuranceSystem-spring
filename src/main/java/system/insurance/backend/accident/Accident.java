package system.insurance.backend.accident;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Accident {
    private int id;
    private int contractId;
    private Date date;
    private Point point;
    private AccidentType accidentType;
    private boolean complete;
    private AccidentInquiryInfo inquiryInfo;
    private DamageAssessmentInfo damageAssessmentInfo;
    private ResponsibilityInfo responsibilityInfo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContractId() {
		return contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public AccidentType getAccidentType() {
		return accidentType;
	}

	public void setAccidentType(AccidentType accidentType) {
		this.accidentType = accidentType;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public AccidentInquiryInfo getInquiryInfo() {
		return inquiryInfo;
	}

	public void setInquiryInfo(AccidentInquiryInfo inquiryInfo) {
		this.inquiryInfo = inquiryInfo;
	}

	public DamageAssessmentInfo getDamageAssessmentInfo() {
		return damageAssessmentInfo;
	}

	public void setDamageAssessmentInfo(DamageAssessmentInfo damageAssessmentInfo) {
		this.damageAssessmentInfo = damageAssessmentInfo;
	}

	public ResponsibilityInfo getResponsibilityInfo() {
		return responsibilityInfo;
	}

	public void setResponsibilityInfo(ResponsibilityInfo responsibilityInfo) {
		this.responsibilityInfo = responsibilityInfo;
	}

    public static class DamageAssessmentInfo {
        private String basis;
        private long amount;
        private String paymentMethod;

		public String getBasis() {
			return basis;
		}
		public void setBasis(String basis) {
			this.basis = basis;
		}
		public long getAmount() {
			return amount;
		}
		public void setAmount(long amount) {
			this.amount = amount;
		}
		public String getPaymentMethod() {
			return paymentMethod;
		}
		public void setPaymentMethod(String paymentMethod) {
			this.paymentMethod = paymentMethod;
		}
    }

    public static class ResponsibilityInfo {
        private ArrayList<String> relevantRegulations;
        private File basisFile;
        private boolean responsibility;
        private String judgementBasis;

		public ArrayList<String> getRelevantRegulations() {
			return relevantRegulations;
		}
		public void setRelevantRegulations(ArrayList<String> relevantRegulations) {
			this.relevantRegulations = relevantRegulations;
		}
		public File getBasisFile() {
			return basisFile;
		}
		public void setBasisFile(File basisFile) {
			this.basisFile = basisFile;
		}
		public boolean isResponsibility() {
			return responsibility;
		}
		public void setResponsibility(boolean responsibility) {
			this.responsibility = responsibility;
		}
		public String getJudgementBasis() {
			return judgementBasis;
		}
		public void setJudgementBasis(String judgementBasis) {
			this.judgementBasis = judgementBasis;
		}
    }

    public static class AccidentInquiryInfo {
        private ArrayList<String> competentAuthority;
        private File record;
        private File picture;
        private File video;
        private String scenario;
        private long processingCost;
        private ArrayList<String> damages;

		public ArrayList<String> getCompetentAuthority() {
			return competentAuthority;
		}
		public void setCompetentAuthority(ArrayList<String> competentAuthority) {
			this.competentAuthority = competentAuthority;
		}
		public File getRecord() {
			return record;
		}
		public void setRecord(File record) {
			this.record = record;
		}
		public File getPicture() {
			return picture;
		}
		public void setPicture(File picture) {
			this.picture = picture;
		}
		public File getVideo() {
			return video;
		}
		public void setVideo(File video) {
			this.video = video;
		}
		public String getScenario() {
			return scenario;
		}
		public void setScenario(String scenario) {
			this.scenario = scenario;
		}
		public long getProcessingCost() {
			return processingCost;
		}
		public void setProcessingCost(long processingCost) {
			this.processingCost = processingCost;
		}
		public ArrayList<String> getDamages() {
			return damages;
		}
		public void setDamages(ArrayList<String> damages) {
			this.damages = damages;
		}
    }
}
