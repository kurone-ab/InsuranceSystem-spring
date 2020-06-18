package system.insurance.backend.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.insurance.backend.client.EnvironmentalFactor;

public interface EnvironmentalFactorRepository extends JpaRepository<EnvironmentalFactor, Integer> {

}
