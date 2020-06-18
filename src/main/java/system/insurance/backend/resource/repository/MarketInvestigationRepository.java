package system.insurance.backend.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.insurance.backend.MarketInvestigation;

public interface MarketInvestigationRepository extends JpaRepository<MarketInvestigation, Integer> {
}
