package system.insurance.backend.resource.controller;

import org.springframework.web.bind.annotation.*;
import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.resource.dto.MarketInvestigationDTO;
import system.insurance.backend.resource.dto.StrategyInvestigationDTO;
import system.insurance.backend.resource.service.InvestigationService;

import java.util.Map;

@RestController
@RequestMapping("/investigation")
public class InvestigationController {
    private final InvestigationService investigationService;

    public InvestigationController(InvestigationService investigationService) {
        this.investigationService = investigationService;
    }

    @GetMapping("/market/list")
    public Map<Integer, MarketInvestigationDTO> getMarketInvestigationList() {
        return this.investigationService.getAllMarketInvestigationList();
    }

    @GetMapping("/market/detail")
    public MarketInvestigationDTO getMarketInvestigationDetail(@RequestParam(name = "id") int id) {
        return this.investigationService.getMarketInvestigationDetail(id);
    }

    @PostMapping("/market/save")
    public boolean addMarketInvestigation(@RequestParam(name = "eid") int eid, @RequestParam(name = "title")String title, @RequestParam(name = "targetClient")String targetClient, @RequestParam(name = "needs") String needs) {
        try {
            return this.investigationService.addMarketInvestigation(eid, title, needs, targetClient);
        } catch (NoEmployeeException e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/strategy/list")
    public Map<Integer, StrategyInvestigationDTO> getStrategyInvestigationList() {
        return this.investigationService.getAllStrategyInvestigationList();
    }

    @GetMapping("/strategy/detail")
    public StrategyInvestigationDTO getStrategyInvestigationDetail(@RequestParam(name = "id") int id) {
        return this.investigationService.getStrategyInvestigationDetail(id);
    }

    @PostMapping("/strategy/save")
    public boolean addStrategyInvestigation(@RequestParam(name = "eid") int eid, @RequestParam(name = "iid")int iid, @RequestParam(name = "title")String title) {
        try {
            return this.investigationService.addStrategyInvestigation(eid, iid, title);
        } catch (NoEmployeeException e) {
            e.printStackTrace();
            return false;
        }
    }
}
