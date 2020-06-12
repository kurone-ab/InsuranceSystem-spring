package system.insurance.backend.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.insurance.backend.insurance.Insurance;
import system.insurance.backend.insurance.InsuranceStatus;
import system.insurance.backend.insurance.InsuranceType;

import java.util.List;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
    List<Insurance> findAllByStatus(InsuranceStatus status);
}
