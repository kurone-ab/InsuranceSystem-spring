package system.insurance.backend.resource.service;

import java.util.List;
import java.util.Map;

public interface InsuranceService {
    Map<String, String> getInsuranceCompanyList();
    Map<String, String> getInsuranceTypeList();
    List<String> getInsuranceProductList();
}
