package system.insurance.backend.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.insurance.backend.employee.Employee;
import system.insurance.backend.insurance.EvaluationReport;
import system.insurance.backend.insurance.Insurance;

import java.util.List;

public interface EvaluationReportRepository extends JpaRepository<EvaluationReport, Integer> {
    List<EvaluationReport> findAllByInsurance(Insurance insurance);
}
