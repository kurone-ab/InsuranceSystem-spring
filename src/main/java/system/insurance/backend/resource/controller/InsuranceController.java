package system.insurance.backend.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import system.insurance.backend.resource.response.ResponseInsuranceInfo;
import system.insurance.backend.resource.service.InsuranceService;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    private InsuranceService insuranceService;

    @Autowired
    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @GetMapping("/info")
    @ResponseBody
    public ResponseInsuranceInfo getInsuranceInfoList() {
        return ResponseInsuranceInfo.builder()
                .companyList(this.insuranceService.getInsuranceCompanyList())
                .productList(this.insuranceService.getInsuranceProductList())
                .build();
    }

}
