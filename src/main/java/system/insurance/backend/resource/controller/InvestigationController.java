package system.insurance.backend.resource.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/strategy/list")
    public Map<Integer, StrategyInvestigationDTO> getStrategyInvestigationList() {
        return this.investigationService.getAllStrategyInvestigationList();
    }

    @GetMapping("/strategy/detail")
    public StrategyInvestigationDTO getStrategyInvestigationDetail(@RequestParam(name = "id") int id) {
        return this.investigationService.getStrategyInvestigationDetail(id);
    }
}
