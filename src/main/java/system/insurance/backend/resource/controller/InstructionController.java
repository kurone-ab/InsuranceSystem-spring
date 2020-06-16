package system.insurance.backend.resource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.insurance.backend.resource.dto.InstructionDTO;
import system.insurance.backend.resource.service.SalesService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/instruction")
public class InstructionController {
    private final SalesService salesService;

    @Autowired
    public InstructionController(SalesService salesService) {
        this.salesService = salesService;
    }

    @PostMapping("/sales/register")
    public ResponseEntity<Boolean> registerInstruction(@RequestBody Map<String, String> body) {
        return ResponseEntity.ok(this.salesService.instructionRegister(body.get("title"), body.get("instruction")));
    }

    @GetMapping("/sales/list")
    @ResponseBody
    public List<InstructionDTO> getInstructionList() {
        return this.salesService.getSalesInstructionList();
    }
}
