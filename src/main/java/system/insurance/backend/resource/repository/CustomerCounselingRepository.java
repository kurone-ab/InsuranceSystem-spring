package system.insurance.backend.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.insurance.backend.counseling.CustomerCounseling;

public interface CustomerCounselingRepository extends JpaRepository<CustomerCounseling, Integer> {

}
