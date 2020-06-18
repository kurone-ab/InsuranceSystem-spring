package system.insurance.backend.resource.service;

import system.insurance.backend.resource.dto.MarketInvestigationDTO;
import system.insurance.backend.resource.dto.StrategyInvestigationDTO;

import java.util.Map;

public interface InvestigationService {
    Map<Integer, MarketInvestigationDTO> getAllMarketInvestigationList();

    MarketInvestigationDTO getMarketInvestigationDetail(int id);

    Map<Integer, StrategyInvestigationDTO> getAllStrategyInvestigationList();

    StrategyInvestigationDTO getStrategyInvestigationDetail(int id);
}
