package system.insurance.backend.resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.insurance.backend.contract.Contract;
import system.insurance.backend.counseling.ClientCounseling;
import system.insurance.backend.employee.Employee;
import system.insurance.backend.exception.NoEmployeeException;
import system.insurance.backend.instruction.Instruction;
import system.insurance.backend.instruction.InstructionType;
import system.insurance.backend.instruction.SalesInstruction;
import system.insurance.backend.resource.dto.InstructionDTO;
import system.insurance.backend.resource.repository.ContractRepository;
import system.insurance.backend.resource.repository.ClientCounselingRepository;
import system.insurance.backend.resource.repository.EmployeeRepository;
import system.insurance.backend.resource.repository.SalesInstructionRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService {
    private final SalesInstructionRepository salesInstructionRepository;
    private final ContractRepository contractRepository;
    private final EmployeeRepository employeeRepository;
    private final ClientCounselingRepository clientCounselingRepository;

    @Autowired
    public SalesServiceImpl(SalesInstructionRepository salesInstructionRepository, ContractRepository contractRepository, EmployeeRepository employeeRepository, ClientCounselingRepository clientCounselingRepository) {
        this.salesInstructionRepository = salesInstructionRepository;
        this.contractRepository = contractRepository;
        this.employeeRepository = employeeRepository;
        this.clientCounselingRepository = clientCounselingRepository;
    }


    @Override
    public boolean instructionRegister(String title, String instruction, int id) throws NoEmployeeException {
        Employee employee = this.employeeRepository.findById(id).orElseThrow(NoEmployeeException::new);
        this.salesInstructionRepository.save(SalesInstruction.builder()
                .author(employee)
                .title(title)
                .instruction(instruction)
                .type(InstructionType.SALES)
                .date(Date.valueOf(LocalDate.now()))
                .build());
        return true;
    }

    @Override
    public List<InstructionDTO> getSalesInstructionList() {
        List<Instruction> salesInstructionList = this.salesInstructionRepository.findAllByType(InstructionType.SALES);
        List<InstructionDTO> instructionDTOList = new ArrayList<>();
        System.out.println(salesInstructionList.toString());
        salesInstructionList.forEach((instruction)->instructionDTOList.add(InstructionDTO.builder()
                .id(instruction.getId())
                .title(instruction.getTitle())
                .authorId(instruction.getAuthor().getId())
                .author(instruction.getAuthor().getName())
                .date(instruction.getDate())
                .build()));
        return instructionDTOList;
    }

    @Override
    public List<Integer> getContractList(int eid) throws NoEmployeeException {
        Optional<Employee> employee = this.employeeRepository.findById(eid);
        Employee employee1 = employee.orElseThrow(NoEmployeeException::new);
        List<Contract> contractList = this.contractRepository.findAllBySalesPerson(employee1);
        List<Integer> ids = new ArrayList<>();
        for (Contract contract : contractList) ids.add(contract.getId());
        System.out.println(ids);
        return ids;
    }

    @Override
    public boolean saveCounselingRecord(String content, int eid) throws NoEmployeeException {
        Optional<Employee> employee = this.employeeRepository.findById(eid);
        Employee employee1 = employee.orElseThrow(NoEmployeeException::new);
        this.clientCounselingRepository.save(ClientCounseling.builder()
                .content(content)
                .counselor(employee1)
                .date(Date.valueOf(LocalDate.now())).build());
        return true;
    }
}
