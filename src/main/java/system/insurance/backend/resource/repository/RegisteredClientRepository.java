package system.insurance.backend.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.insurance.backend.client.Client;
import system.insurance.backend.client.RegisteredClient;

import java.util.Optional;

public interface RegisteredClientRepository extends JpaRepository<RegisteredClient, Integer> {
    Optional<Client> findByRrn(String rrn);
    Optional<Client> findByName(String name);
    Optional<Client> findByContact(String contact);
}
