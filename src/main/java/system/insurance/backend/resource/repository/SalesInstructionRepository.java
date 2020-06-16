package system.insurance.backend.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.insurance.backend.instruction.Instruction;
import system.insurance.backend.instruction.InstructionType;
import system.insurance.backend.instruction.SalesInstruction;

import java.util.List;

public interface SalesInstructionRepository extends InstructionRepository<SalesInstruction, Integer> {
    List<Instruction> findAllByType(InstructionType type);
}
