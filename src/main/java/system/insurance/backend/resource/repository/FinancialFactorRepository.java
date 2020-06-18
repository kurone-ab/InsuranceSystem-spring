package system.insurance.backend.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.insurance.backend.client.FinancialFactor;

public interface FinancialFactorRepository extends JpaRepository<FinancialFactor, Integer> {
}
