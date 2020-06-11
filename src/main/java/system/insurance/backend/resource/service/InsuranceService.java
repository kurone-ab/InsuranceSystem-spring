package system.insurance.backend.resource.service;

import system.insurance.backend.resource.dto.DevelopingInsuranceDTO;
import system.insurance.backend.resource.dto.InsuranceDTO;

import java.util.List;
import java.util.Map;

public interface InsuranceService {
    Map<String, String> getInsuranceCompanyList();
    Map<String, String> getInsuranceTypeList();
    Map<Integer, String> getProductNameList();
    List<InsuranceDTO> getInsuranceProductList();
    List<DevelopingInsuranceDTO> getDevelopingInsuranceList();
}
