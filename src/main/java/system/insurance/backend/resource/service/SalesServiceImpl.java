package system.insurance.backend.resource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.insurance.backend.instruction.Instruction;
import system.insurance.backend.instruction.InstructionType;
import system.insurance.backend.instruction.SalesInstruction;
import system.insurance.backend.resource.dto.InstructionDTO;
import system.insurance.backend.resource.repository.SalesInstructionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {
    private final SalesInstructionRepository salesInstructionRepository;

    @Autowired
    public SalesServiceImpl(SalesInstructionRepository salesInstructionRepository) {
        this.salesInstructionRepository = salesInstructionRepository;
    }


    @Override
    public boolean instructionRegister(String title, String instruction) {
        this.salesInstructionRepository.save(SalesInstruction.builder()
                .title(title)
                .instruction(instruction)
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
}
