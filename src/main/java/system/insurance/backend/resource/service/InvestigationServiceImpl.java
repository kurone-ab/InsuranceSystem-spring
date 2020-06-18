package system.insurance.backend.resource.service;

import lombok.Builder;
import org.springframework.stereotype.Service;
import system.insurance.backend.MarketInvestigation;
import system.insurance.backend.StrategyInvestigation;
import system.insurance.backend.resource.dto.MarketInvestigationDTO;
import system.insurance.backend.resource.dto.StrategyInvestigationDTO;
import system.insurance.backend.resource.repository.MarketInvestigationRepository;
import system.insurance.backend.resource.repository.StrategyInvestigationRepository;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class InvestigationServiceImpl implements InvestigationService {
    private final MarketInvestigationRepository marketInvestigationRepository;
    private final StrategyInvestigationRepository strategyInvestigationRepository;

    @Builder
    public InvestigationServiceImpl(MarketInvestigationRepository marketInvestigationRepository, StrategyInvestigationRepository strategyInvestigationRepository) {
        this.marketInvestigationRepository = marketInvestigationRepository;
        this.strategyInvestigationRepository = strategyInvestigationRepository;
    }

    @Override
    public Map<Integer, MarketInvestigationDTO> getAllMarketInvestigationList() {
        Map<Integer, MarketInvestigationDTO> marketInvestigationDTOList = new Hashtable<>();
        List<MarketInvestigation> marketInvestigationList = this.marketInvestigationRepository.findAll();
        marketInvestigationList.forEach(marketInvestigation -> marketInvestigationDTOList.put(marketInvestigation.getId(),
                MarketInvestigationDTO.builder()
                        .title(marketInvestigation.getTitle())
                        .author(marketInvestigation.getAuthor().getName())
                        .date(marketInvestigation.getDate())
                        .build()
                ));
        return marketInvestigationDTOList;
    }

    @Override
    public MarketInvestigationDTO getMarketInvestigationDetail(int id) {
        Optional<MarketInvestigation> marketInvestigationOptional = this.marketInvestigationRepository.findById(id);
        if (marketInvestigationOptional.isPresent()){
            MarketInvestigation marketInvestigation = marketInvestigationOptional.get();
            return MarketInvestigationDTO.builder()
                    .targetClient(marketInvestigation.getTargetClient())
                    .needs(marketInvestigation.getNeeds())
                    .build();
        }
        return MarketInvestigationDTO.builder().build();
    }

    @Override
    public Map<Integer, StrategyInvestigationDTO> getAllStrategyInvestigationList() {
        Map<Integer, StrategyInvestigationDTO> strategyInvestigationDTOMap = new Hashtable<>();
        List<StrategyInvestigation> strategyInvestigations = this.strategyInvestigationRepository.findAll();
        strategyInvestigations.forEach(strategyInvestigation -> strategyInvestigationDTOMap.put(strategyInvestigation.getId(),
                StrategyInvestigationDTO.builder()
                        .title(strategyInvestigation.getTitle())
                        .author(strategyInvestigation.getAuthor().getName())
                        .date(strategyInvestigation.getDate())
                        .build()
                ));
        return strategyInvestigationDTOMap;
    }

    @Override
    public StrategyInvestigationDTO getStrategyInvestigationDetail(int id) {
        Optional<StrategyInvestigation> strategyInvestigationOptional = this.strategyInvestigationRepository.findById(id);
        if (strategyInvestigationOptional.isPresent()){
            StrategyInvestigation strategyInvestigation = strategyInvestigationOptional.get();
            return StrategyInvestigationDTO.builder()
                    .company(strategyInvestigation.getInsurance().getCompany().getDescription())
                    .insurance(strategyInvestigation.getInsurance().getName())
                    .insuranceId(strategyInvestigation.getInsurance().getId())
                    .build();
        }
        return StrategyInvestigationDTO.builder().build();
    }
}
