package system.insurance.backend.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import system.insurance.backend.resource.dto.DevelopingInsuranceDTO;
import system.insurance.backend.resource.dto.InsuranceDTO;
import system.insurance.backend.resource.dto.InsuranceInfoDTO;
import system.insurance.backend.resource.service.InsuranceService;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    private final InsuranceService insuranceService;

    @Autowired
    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping("/info")
    @ResponseBody
    public InsuranceInfoDTO getInsuranceInfoList() {
        return InsuranceInfoDTO.builder()
                .companyList(this.insuranceService.getInsuranceCompanyList())
                .typeList(this.insuranceService.getInsuranceTypeList())
                .productNameList(this.insuranceService.getProductNameList())
                .build();
    }

    @GetMapping("/product")
    public List<InsuranceDTO> getProductList() {
        return this.insuranceService.getInsuranceProductList();
    }

    @GetMapping("/product/developing")
    public List<DevelopingInsuranceDTO> getDevelopingInsuranceList() {
        System.out.println("controller");
        return this.insuranceService.getDevelopingInsuranceList();
    }

}
