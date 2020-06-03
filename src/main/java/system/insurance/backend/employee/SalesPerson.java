package system.insurance.backend.employee;

import system.insurance.backend.contract.ContractListImpl;

public class SalesPerson extends Employee {
    private ContractListImpl contractList;

    public ContractListImpl getContractList() {
        return contractList;
    }

    public void setContractList(ContractListImpl contractList) {
        this.contractList = contractList;
    }
}
