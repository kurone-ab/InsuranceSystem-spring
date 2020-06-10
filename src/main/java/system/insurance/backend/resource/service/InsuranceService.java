package system.insurance.backend.resource.service;

import java.util.List;
import java.util.Map;

public interface InsuranceService {
    Map<String, String> getInsuranceCompanyList();
    List<String> getInsuranceProductList();
}
