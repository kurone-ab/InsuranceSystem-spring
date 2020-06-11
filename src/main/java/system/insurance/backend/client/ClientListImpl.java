package system.insurance.backend.client;

import system.insurance.backend.exception.NoClientException;

import java.util.ArrayList;
import java.util.Objects;

public class ClientListImpl extends ArrayList<Client> implements ClientList {
	private static final long serialVersionUID = 1L;

	public ClientListImpl(boolean createSample) {
		super();
//		if (createSample) {
//			Client client = new JoinedClient();
//			client.setSex(Sex.male);
//			client.setName("김만수");
//			client.setAge(22);
//			this.create(client);
//			client = new JoinedClient();
//			client.setSex(Sex.male);
//			client.setName("박성제");
//			client.setAge(22);
//			this.create(client);
//			client = new JoinedClient();
//			client.setSex(Sex.male);
//			client.setName("박정욱");
//			client.setAge(23);
//			this.create(client);
//		}
	}

	public ClientListImpl() {
		super();
	}

	public boolean deleteClient(int id) throws NoClientException {
		for (Client client : this) {
			if (client.getId() == id) {
				return this.remove(client);
			}
		}
		throw new NoClientException();
	}

	public boolean create(Client client) {
		if (client != null) {
			return this.add(client);
		}
		return false;
	}

	public Client retrieveById(int id) throws NoClientException {
		for (Client client : this) {
			if (client.getId() == id) {
				return client;
			}
		}
		throw new NoClientException();
	}

	public boolean updateInfo(Client client) {
		if (client == null) {
			return false;
		}
		this.set(this.indexOf(client), client);
		return true;
	}

	public Client retrieveByPhone(String phoneNo) throws NoClientException {
		for (Client client : this) {
			if (Objects.equals(client.getContact(), phoneNo)) {
				return client;
			}
		}
		throw new NoClientException();
	}

	public ClientListImpl retrieveByName(String name) {
		ClientListImpl temp = new ClientListImpl();

		for (Client client : this) {
			if (Objects.equals(client.getName(), name)) {
				temp.add(client);
			}
		}

		return temp;
	}

	public Client retrieveByRRN(String rrn) throws NoClientException {
		for (Client client : this) {
			if (Objects.equals(client.getRrn(), rrn)) {
				return client;
			}
		}
		throw new NoClientException();
	}
}
