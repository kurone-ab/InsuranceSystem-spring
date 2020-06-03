package system.insurance.backend.client;

import system.insurance.backend.exception.NoClientException;

public interface ClientList {

    boolean deleteClient(int id) throws NoClientException;

    boolean create(Client client);

    Client retrieveById(int id) throws NoClientException;

    boolean updateInfo(Client client);

    Client retrieveByPhone(String phoneNo) throws NoClientException;

    ClientListImpl retrieveByName(String name) throws NoClientException;

    Client retrieveByRRN(String rrn) throws NoClientException;
}
