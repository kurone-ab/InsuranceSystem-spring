package system.insurance.backend.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import system.insurance.backend.resource.dto.DevelopingInsuranceDTO;
import system.insurance.backend.resource.dto.InsuranceDTO;
import system.insurance.backend.resource.dto.InsuranceDetailsDTO;
import system.insurance.backend.resource.dto.InsuranceInfoDTO;
import system.insurance.backend.resource.service.InsuranceService;

import java.io.IOException;
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
                .productList(this.insuranceService.getProductList())
                .build();
    }

    @GetMapping("/product/developing")
    public List<DevelopingInsuranceDTO> getDevelopingInsuranceList() {
        return this.insuranceService.getDevelopingInsuranceList();
    }

    @GetMapping("/product")
    public ResponseEntity<InsuranceDetailsDTO> getInsuranceDetails(@RequestParam(name = "id") int id){
        return ResponseEntity.of(this.insuranceService.getInsuranceDetails(id));
    }

    @PostMapping("/authorize")
    public ResponseEntity<Boolean> uploadAuthorizationDoc(@RequestParam(name = "file")MultipartFile file) {
        try {
            return ResponseEntity.of(this.insuranceService.uploadAuthorizationDoc(file));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ok(false);
        }
    }

}
