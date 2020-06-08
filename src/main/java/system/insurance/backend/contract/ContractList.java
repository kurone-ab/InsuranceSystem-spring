package system.insurance.backend.contract;

import system.insurance.backend.exception.NoContractException;

import java.util.Date;

public interface ContractList {

    boolean create(Contract contract);

    Contract retrieveById(int contractId) throws NoContractException;

    ContractListImpl retrieveByClientId(int clientId) throws NoContractException;

    Contract retrieveInsIdClientId(int insuranceId, int clientId) throws NoContractException;

    ContractListImpl retrieveByInsId(int insuranceId) throws NoContractException;

    boolean update(int contractId, Date date);

    boolean delete(int contractId) throws NoContractException;
}
