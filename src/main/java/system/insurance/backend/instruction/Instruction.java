package system.insurance.backend.instruction;

import lombok.*;
import system.insurance.backend.employee.Employee;

import javax.persistence.*;
import java.sql.Date;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public abstract class Instruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 500)
    private String title;
    @Column(columnDefinition = "text")
    private String instruction;
    @Enumerated(EnumType.STRING)
    private InstructionType type;
    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "author", referencedColumnName = "id")
    private Employee author;
    @Column(columnDefinition = "date")
    private Date date;

    public Instruction(String title, String instruction, InstructionType type, Employee author, Date date) {
        this.title = title;
        this.instruction = instruction;
        this.type = type;
        this.author = author;
        this.date = date;
    }
}
