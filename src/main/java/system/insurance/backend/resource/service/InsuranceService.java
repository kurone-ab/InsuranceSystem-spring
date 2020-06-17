package system.insurance.backend.resource.service;

import org.springframework.web.multipart.MultipartFile;
import system.insurance.backend.resource.dto.DevelopingInsuranceDTO;
import system.insurance.backend.resource.dto.InsuranceDTO;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface InsuranceService {
    Map<String, String> getInsuranceCompanyList();
    Map<String, String> getInsuranceTypeList();
    Map<Integer, InsuranceDTO> getProductList();
    List<DevelopingInsuranceDTO> getDevelopingInsuranceList();
    Optional<InsuranceDTO> getInsuranceDetails(int id);
    boolean uploadAuthorizationDoc(MultipartFile file) throws IOException;
    boolean uploadEvaluationReport(List<MultipartFile> files, int insuranceId) throws IOException;

    File downloadEvaluationReport(int id) throws IOException;
}
