package system.insurance.backend.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.insurance.backend.insurance.GuaranteeInfo;
import system.insurance.backend.insurance.Insurance;

import java.util.List;

public interface GuaranteeInfoRepository extends JpaRepository<GuaranteeInfo, Integer> {
    List<GuaranteeInfo> findAllByInsurance(Insurance insurance);
}
