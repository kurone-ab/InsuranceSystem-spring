package system.insurance.backend.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.insurance.backend.insurance.Insurance;
import system.insurance.backend.insurance.SalesTarget;

import java.util.List;

public interface SalesTargetRepository extends JpaRepository<SalesTarget, Integer> {
    List<SalesTarget> findAllByInsurance(Insurance insurance);
}
