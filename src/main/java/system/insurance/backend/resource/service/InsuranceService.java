package system.insurance.backend.resource.service;

import system.insurance.backend.resource.dto.DevelopingInsuranceDTO;
import system.insurance.backend.resource.dto.InsuranceDTO;
import system.insurance.backend.resource.dto.InsuranceDetailsDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface InsuranceService {
    Map<String, String> getInsuranceCompanyList();
    Map<String, String> getInsuranceTypeList();
    List<InsuranceDTO> getProductList();
    List<InsuranceDTO> getInsuranceProductList();
    List<DevelopingInsuranceDTO> getDevelopingInsuranceList();
    Optional<InsuranceDetailsDTO> getInsuranceDetails(int id);
}
