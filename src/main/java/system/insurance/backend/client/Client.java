package system.insurance.backend.client;

import java.util.Optional;

public abstract class Client {
    private static int size;
    private final int id;
    private String contact;
    private int age;
    private Sex sex;
    private String name;
    private String email;

    public Client() {
        this.id = ++size;
    }

    public int getId() {
        return id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Optional<Boolean> isConsentPersonalInformation() {
        return Optional.empty();
    }

    public void setConsentPersonalInformation(boolean consentPersonalInformation) {
    }

    public JoiningClient.EnvironmentalFactor getEnvironmentalFactor() {
        return null;
    }

    public void setEnvironmentalFactor(JoiningClient.EnvironmentalFactor environmentalFactor) {
    }

    public JoiningClient.FinancialFactor getFinancialFactor() {
        return null;
    }

    public void setFinancialFactor(JoiningClient.FinancialFactor financialFactor) {
    }

    public JoiningClient.MoralFactor getMoralFactor() {
        return null;
    }

    public void setMoralFactor(JoiningClient.MoralFactor moralFactor) {
    }

    public JoiningClient.PhysicalFactor getPhysicalFactor() {
        return null;
    }

    public void setPhysicalFactor(JoiningClient.PhysicalFactor physicalFactor) {
    }

    public int getInsuranceId() {
        return -1;
    }

    public void setInsuranceId(int insuranceId) {
    }

    public String getRrn() {
        return null;
    }

    public void setRrn(String rrn) {
    }

    public String getSubContact() {
        return null;
    }

    public void setSubContact(String subContact) {
    }
}
