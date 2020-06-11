package system.insurance.backend.resource.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import system.insurance.backend.contract.InsuranceCo;
import system.insurance.backend.insurance.InsuranceType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Override
    @ResponseBody
    public Map<String, String> getInsuranceCompanyList() {
        Map<String, String> companyList = new HashMap<>();
        for (InsuranceCo value : InsuranceCo.values()) {
            companyList.put(value.name(), value.getDescription());
        }
        return companyList;
    }

    @Override
    public Map<String, String> getInsuranceTypeList() {
        Map<String, String> typeList = new HashMap<>();
        for (InsuranceType value : InsuranceType.values()) {
            typeList.put(value.name(), value.getDescription());
        }
        return typeList;
    }

    @Override
    @ResponseBody
    public List<String> getInsuranceProductList() {
        List<String> list = new ArrayList<>();
        list.add("보험 상품 1");
        list.add("보험 상품 2");
        list.add("보험 상품 3");
        list.add("보험 상품 4");
        list.add("보험 상품 5");
        return list;
    }
}
