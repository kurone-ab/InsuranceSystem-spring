package system.insurance.backend.employee;

public class SalesManager extends Employee {
    private EmployeeListImpl staffInChargeList;

    public EmployeeListImpl getStaffInChargeList() {
        return staffInChargeList;
    }

    public void setStaffInChargeList(EmployeeListImpl staffInChargeList) {
        this.staffInChargeList = staffInChargeList;
    }
}
