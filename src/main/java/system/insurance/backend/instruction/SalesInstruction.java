package system.insurance.backend.instruction;

import lombok.Builder;
import system.insurance.backend.employee.Employee;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "sales_instruction")
public class SalesInstruction extends Instruction{
    protected SalesInstruction() {
    }

    @Builder
    public SalesInstruction(String title, String instruction, InstructionType type, Employee author, Date date) {
        super(title, instruction, type, author, date);
    }
}
