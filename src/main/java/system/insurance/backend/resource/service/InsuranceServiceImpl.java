package system.insurance.backend.resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import system.insurance.backend.insurance.*;
import system.insurance.backend.resource.dto.DevelopingInsuranceDTO;
import system.insurance.backend.resource.dto.InsuranceDTO;
import system.insurance.backend.resource.repository.GuaranteeInfoRepository;
import system.insurance.backend.resource.repository.InsuranceRepository;
import system.insurance.backend.resource.repository.SalesTargetRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InsuranceServiceImpl implements InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final GuaranteeInfoRepository guaranteeRepository;
    private final SalesTargetRepository salesTargetRepository;

    @Autowired
    public InsuranceServiceImpl(InsuranceRepository insuranceRepository, GuaranteeInfoRepository guaranteeRepository, SalesTargetRepository salesTargetRepository) {
        this.insuranceRepository = insuranceRepository;
        this.guaranteeRepository = guaranteeRepository;
        this.salesTargetRepository = salesTargetRepository;
    }

    @Override
    public Map<String, String> getInsuranceCompanyList() {
        Map<String, String> companyList = new HashMap<>();
        for (InsuranceCompany value : InsuranceCompany.values()) {
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
    public Map<Integer, String> getProductNameList() {
        Map<Integer, String> productNameList = new HashMap<>();
        List<Insurance> insuranceList = this.insuranceRepository.findAll();
        insuranceList.forEach(insurance -> productNameList.put(insurance.getId(), insurance.getName()));
        return productNameList;
    }

    @Override
    @ResponseBody
    public List<InsuranceDTO> getInsuranceProductList() {
        List<InsuranceDTO> list = new ArrayList<>();
        List<Insurance> insuranceList = this.insuranceRepository.findAll();
        for (Insurance insurance : insuranceList) {
            List<GuaranteeInfo> guaranteeInfoList = this.guaranteeRepository.findAllByInsurance(insurance);
            List<SalesTarget> salesTargetList = this.salesTargetRepository.findAllByInsurance(insurance);
            List<String> salesTargetStringList = new ArrayList<>();
            Map<String, Long> guaranteeInfoStringList = new HashMap<>();
            guaranteeInfoList.forEach(guaranteeInfo -> guaranteeInfoStringList.put(guaranteeInfo.getGuaranteeCondition(), guaranteeInfo.getGuaranteeLimit()));
            salesTargetList.forEach(salesTarget -> salesTargetStringList.add(salesTarget.getTarget()));
            list.add(InsuranceDTO.builder()
                    .company(insurance.getCompany())
                    .guaranteeInfos(guaranteeInfoStringList)
                    .salesTarget(salesTargetStringList)
                    .id(insurance.getId())
                    .name(insurance.getName())
                    .status(insurance.getStatus())
                    .type(insurance.getType())
                    .author(insurance.getAuthor().getName())
                    .date(insurance.getDate())
                    .build());
        }
        return list;
    }

    @Override
    public List<DevelopingInsuranceDTO> getDevelopingInsuranceList() {
        List<Insurance> list = this.insuranceRepository.findAllByStatus(InsuranceStatus.DEVELOPING);
        List<DevelopingInsuranceDTO> dtoList = new ArrayList<>();
        list.forEach(insurance -> dtoList.add(DevelopingInsuranceDTO.builder()
                .id(insurance.getId())
                .author(insurance.getAuthor().getName())
                .date(insurance.getDate())
                .name(insurance.getName())
                .build()));
        return dtoList;
    }
}
