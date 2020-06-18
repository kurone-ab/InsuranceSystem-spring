package system.insurance.backend.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.insurance.backend.counseling.ClientCounseling;

public interface ClientCounselingRepository extends JpaRepository<ClientCounseling, Integer> {

}
