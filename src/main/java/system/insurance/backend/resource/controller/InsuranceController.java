package system.insurance.backend.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import system.insurance.backend.resource.dto.DevelopingInsuranceDTO;
import system.insurance.backend.resource.dto.InsuranceDTO;
import system.insurance.backend.resource.dto.InsuranceInfoDTO;
import system.insurance.backend.resource.service.InsuranceService;

import javax.servlet.http.HttpServletResponse;
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

    @GetMapping("/product/detail")
    public ResponseEntity<InsuranceDTO> getInsuranceDetails(@RequestParam(name = "id") int id){
        return ResponseEntity.of(this.insuranceService.getInsuranceDetails(id));
    }

    @PostMapping("/authorize")
    public ResponseEntity<Boolean> uploadAuthorizationDoc(@RequestParam(name = "file")MultipartFile file) {
        try {
            return ResponseEntity.ok(this.insuranceService.uploadAuthorizationDoc(file));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ok(false);
        }
    }

    @PostMapping("/evaluation")
    public ResponseEntity<Boolean> uploadEvaluationReport(@RequestParam(name = "file")MultipartFile file) {
        try {
            return ResponseEntity.ok(this.insuranceService.uploadEvaluationReport(file));
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping("/evaluation")
    public FileSystemResource downloadEvaluationReport(@RequestParam(name = "id")int id, HttpServletResponse res){
        res.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment");
        System.out.println(id);
        try {
            return new FileSystemResource(this.insuranceService.downloadEvaluationReport(id));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
