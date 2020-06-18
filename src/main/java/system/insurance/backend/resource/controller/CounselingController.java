package system.insurance.backend.resource.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.resource.service.SalesService;

@RestController
@RequestMapping("/counseling")
public class CounselingController {
    private final SalesService salesService;

    public CounselingController(SalesService salesService) {
        this.salesService = salesService;
    }

    @PostMapping("/record/register")
    public boolean saveRecord(@RequestParam(name = "content") String content, @RequestParam(name = "eid")int eid){
        try {
            return this.salesService.saveCounselingRecord(content, eid);
        } catch (NoEmployeeException e) {
            e.printStackTrace();
            return false;
        }
    }


}
