package system.insurance.backend.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.insurance.backend.instruction.Instruction;

import java.io.Serializable;

public interface InstructionRepository<T extends Instruction, E extends Serializable> extends JpaRepository<T, E> {
}
