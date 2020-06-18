package system.insurance.backend.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.insurance.backend.StrategyInvestigation;

public interface StrategyInvestigationRepository extends JpaRepository<StrategyInvestigation, Integer> {
}
