package system.insurance.backend.client;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class JoiningClient extends Client {
    private EnvironmentalFactor environmentalFactor;
    private FinancialFactor financialFactor;
    private MoralFactor moralFactor;
    private PhysicalFactor physicalFactor;
    private int insuranceId;
    private String rrn;
    private boolean consentPersonalInformation;


    public Optional<Boolean> isConsentPersonalInformation() {
        return Optional.of(consentPersonalInformation);
    }

    public void setConsentPersonalInformation(boolean consentPersonalInformation) {
        this.consentPersonalInformation = consentPersonalInformation;
    }

    public EnvironmentalFactor getEnvironmentalFactor() {
        return environmentalFactor;
    }

    public void setEnvironmentalFactor(EnvironmentalFactor environmentalFactor) {
        this.environmentalFactor = environmentalFactor;
    }

    public FinancialFactor getFinancialFactor() {
        return financialFactor;
    }

    public void setFinancialFactor(FinancialFactor financialFactor) {
        this.financialFactor = financialFactor;
    }

    public MoralFactor getMoralFactor() {
        return moralFactor;
    }

    public void setMoralFactor(MoralFactor moralFactor) {
        this.moralFactor = moralFactor;
    }

    public PhysicalFactor getPhysicalFactor() {
        return physicalFactor;
    }

    public void setPhysicalFactor(PhysicalFactor physicalFactor) {
        this.physicalFactor = physicalFactor;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }

    public static class EnvironmentalFactor {
        private int UWScore;
        private Point residence;
        private boolean dangerZone;
        private boolean dangerHobby;
        private Job job;

        public int getUWScore() {
            return UWScore;
        }

        public void setUWScore(int UWScore) {
            this.UWScore = UWScore;
        }

        public Point getResidence() {
            return residence;
        }

        public void setResidence(Point residence) {
            this.residence = residence;
        }

        public boolean isDangerZone() {
            return dangerZone;
        }

        public void setDangerZone(boolean dangerZone) {
            this.dangerZone = dangerZone;
        }

        public boolean isDangerHobby() {
            return dangerHobby;
        }

        public void setDangerHobby(boolean dangerHobby) {
            this.dangerHobby = dangerHobby;
        }

        public Job getJob() {
            return job;
        }

        public void setJob(Job job) {
            this.job = job;
        }
    }

    public static class FinancialFactor {
        private int UWScore;
        private long income;
        private int creditRating;
        private long property;

        public int getUWScore() {
            return UWScore;
        }

        public void setUWScore(int UWScore) {
            this.UWScore = UWScore;
        }

        public long getIncome() {
            return income;
        }

        public void setIncome(long income) {
            this.income = income;
        }

        public int getCreditRating() {
            return creditRating;
        }

        public void setCreditRating(int creditRating) {
            this.creditRating = creditRating;
        }

        public long getPropertyReport() {
            return property;
        }

        public void setPropertyReport(long property) {
            this.property = property;
        }
    }

    public static class MoralFactor {
        private int UWScore;
        private ArrayList<String> insuranceHistory;

        public int getUWScore() {
            return UWScore;
        }

        public void setUWScore(int UWScore) {
            this.UWScore = UWScore;
        }

        public ArrayList<String> getInsuranceHistory() {
            return insuranceHistory;
        }

        public void setInsuranceHistory(String... insuranceHistory) {
            this.insuranceHistory.addAll(Arrays.asList(insuranceHistory));
        }
    }

    public static class PhysicalFactor {
        private int UWScore;
        private final ArrayList<String> accidentHistory = new ArrayList<>();
        private boolean isDrinking;
        private boolean isSmoking;
        private final ArrayList<Disease> diseases = new ArrayList<>();
        private final ArrayList<Treatment> treatments = new ArrayList<>();

        public int getUWScore() {
            return UWScore;
        }

        public void setUWScore(int UWScore) {
            this.UWScore = UWScore;
        }

        public ArrayList<String> getAccidentHistory() {
            return accidentHistory;
        }

        public void addAccidentHistory(String... accidentHistory){
            if (accidentHistory.length == 1) this.accidentHistory.add(accidentHistory[0]);
            else this.accidentHistory.addAll(Arrays.asList(accidentHistory));
        }

        public boolean isDrinking() {
            return isDrinking;
        }

        public void setDrinking(boolean drinking) {
            isDrinking = drinking;
        }

        public boolean isSmoking() {
            return isSmoking;
        }

        public void setSmoking(boolean smoking) {
            isSmoking = smoking;
        }

        public ArrayList<Disease> getDiseases() {
            return diseases;
        }

        public ArrayList<Treatment> getTreatments() {
            return treatments;
        }

        public static class Disease {
            private int id;
            private String code;
            private boolean completeCure;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public boolean isCompleteCure() {
                return completeCure;
            }

            public void setCompleteCure(boolean completeCure) {
                this.completeCure = completeCure;
            }
        }

        public static class Treatment {
            private int id;
            private String EDICode;
            private String surgeryCode;
            private boolean completeCure;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getEDICode() {
                return EDICode;
            }

            public void setEDICode(String EDICode) {
                this.EDICode = EDICode;
            }

            public String getSurgeryCode() {
                return surgeryCode;
            }

            public void setSurgeryCode(String surgeryCode) {
                this.surgeryCode = surgeryCode;
            }

            public boolean isCompleteCure() {
                return completeCure;
            }

            public void setCompleteCure(boolean completeCure) {
                this.completeCure = completeCure;
            }
        }

    }
}
