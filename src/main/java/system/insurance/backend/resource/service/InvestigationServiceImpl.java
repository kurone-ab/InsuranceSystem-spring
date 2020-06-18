package system.insurance.backend.resource.service;

import lombok.Builder;
import org.springframework.stereotype.Service;
import system.insurance.backend.MarketInvestigation;
import system.insurance.backend.StrategyInvestigation;
import system.insurance.backend.employee.Employee;
import system.insurance.backend.exception.InvalidIdentifierException;
import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.insurance.Insurance;
import system.insurance.backend.resource.dto.MarketInvestigationDTO;
import system.insurance.backend.resource.dto.StrategyInvestigationDTO;
import system.insurance.backend.resource.repository.EmployeeRepository;
import system.insurance.backend.resource.repository.InsuranceRepository;
import system.insurance.backend.resource.repository.MarketInvestigationRepository;
import system.insurance.backend.resource.repository.StrategyInvestigationRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class InvestigationServiceImpl implements InvestigationService {
    private final MarketInvestigationRepository marketInvestigationRepository;
    private final StrategyInvestigationRepository strategyInvestigationRepository;
    private final EmployeeRepository employeeRepository;
    private final InsuranceRepository insuranceRepository;

    @Builder
    public InvestigationServiceImpl(MarketInvestigationRepository marketInvestigationRepository, StrategyInvestigationRepository strategyInvestigationRepository, EmployeeRepository employeeRepository, InsuranceRepository insuranceRepository) {
        this.marketInvestigationRepository = marketInvestigationRepository;
        this.strategyInvestigationRepository = strategyInvestigationRepository;
        this.employeeRepository = employeeRepository;
        this.insuranceRepository = insuranceRepository;
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
    public boolean addMarketInvestigation(int eid, String title, String needs, String targetClient) throws NoEmployeeException {
        Optional<Employee> employeeOptional = this.employeeRepository.findById(eid);
        Employee employee = employeeOptional.orElseThrow(NoEmployeeException::new);
        this.marketInvestigationRepository.save(MarketInvestigation.builder()
                .author(employee)
                .date(Date.valueOf(LocalDate.now()))
                .needs(needs)
                .targetClient(targetClient)
                .title(title)
                .build());
        return true;
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

    @Override
    public boolean addStrategyInvestigation(int eid, int iid, String title) throws NoEmployeeException {
        Optional<Employee> employeeOptional = this.employeeRepository.findById(eid);
        Employee employee = employeeOptional.orElseThrow(NoEmployeeException::new);
        Optional<Insurance> insuranceOptional = this.insuranceRepository.findById(iid);
        Insurance insurance = insuranceOptional.orElseThrow(InvalidIdentifierException::new);
        this.strategyInvestigationRepository.save(
                StrategyInvestigation.builder()
                        .author(employee)
                        .date(Date.valueOf(LocalDate.now()))
                        .insurance(insurance)
                        .title(title)
                        .build()
        );
        return true;
    }
}
