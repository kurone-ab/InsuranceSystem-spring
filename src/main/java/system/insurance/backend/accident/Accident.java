package system.insurance.backend.accident;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
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

	@Getter
	@Setter
    public static class DamageAssessmentInfo {
        private String basis;
        private long amount;
        private String paymentMethod;
    }

	@Getter
	@Setter
    public static class ResponsibilityInfo {
        private ArrayList<String> relevantRegulations;
        private File basisFile;
        private boolean responsibility;
        private String judgementBasis;
    }

    @Getter
	@Setter
    public static class AccidentInquiryInfo {
        private ArrayList<String> competentAuthority;
        private File record;
        private File picture;
        private File video;
        private String scenario;
        private long processingCost;
        private ArrayList<String> damages;

    }
}
