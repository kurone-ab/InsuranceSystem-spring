package system.insurance.backend.contract;

import system.insurance.backend.exception.NoContractException;

import java.util.ArrayList;
import java.util.Date;

public class ContractListImpl extends ArrayList<Contract> implements ContractList {
	static final long serialVersionUID = 1L;

	public boolean create(Contract contract) {
		if (contract != null) {
			return this.add(contract);
		}
		return false;
	}

	public Contract retrieveById(int contractId) throws NoContractException {
		for (Contract contract : this) {
			if (contract.getId() == contractId) {
				return contract;
			}
		}
		throw new NoContractException();
	}

	public ContractListImpl retrieveByClientId(int clientId) throws NoContractException {
		ContractListImpl temp = new ContractListImpl();

		for (Contract contract : this) {
			if (contract.getClientId() == clientId) {
				temp.add(contract);
			}
		}

		if (temp.size() != 0) {
			return temp;
		} else {
			throw new NoContractException();
		}
	}

	public Contract retrieveInsIdClientId(int insuranceId, int clientId) throws NoContractException {
		for (Contract contract : this) {
			if (contract.getInsuranceId() == insuranceId) {
				if (contract.getClientId() == clientId) {
					return contract;
				}
			}
		}
		throw new NoContractException();
	}

//	public Contract retrieveBySalesPerson(SalesPerson salesPerson) throws NoContractException {
//		for (Contract contract : this) {
//			if (contract.getSalesPerson() == salesPerson) {
//				return contract;
//			}
//		}
//		throw new NoContractException();
//	}

	public ContractListImpl retrieveByInsId(int insuranceId) throws NoContractException {
		ContractListImpl temp = new ContractListImpl();

		for (Contract contract : this) {
			if (contract.getInsuranceId() == insuranceId) {
				temp.add(contract);
			}
		}

		if (temp.size() != 0) {
			return temp;
		} else {
			throw new NoContractException();
		}
	}

	public boolean update(int contractId, Date date) {
		for (Contract contract : this) {
			if (contract.getId() == contractId) {
				contract.setDueDate(date);
				return true;
			}
		}
		return false;
	}

	public boolean delete(int contractId) throws NoContractException {
		for (Contract contract : this) {
			if (contract.getId() == contractId) {
				return this.remove(contract);
			}
		}
		throw new NoContractException();
	}
}
