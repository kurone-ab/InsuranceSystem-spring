package system.insurance.backend.resource.service;

import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.resource.dto.MarketInvestigationDTO;
import system.insurance.backend.resource.dto.StrategyInvestigationDTO;

import java.util.Map;

public interface InvestigationService {
    Map<Integer, MarketInvestigationDTO> getAllMarketInvestigationList();

    MarketInvestigationDTO getMarketInvestigationDetail(int id);

    boolean addMarketInvestigation(int eid, String title, String needs, String targetClient) throws NoEmployeeException;

    Map<Integer, StrategyInvestigationDTO> getAllStrategyInvestigationList();

    StrategyInvestigationDTO getStrategyInvestigationDetail(int id);

    boolean addStrategyInvestigation(int eid, int iid, String title) throws NoEmployeeException;
}
