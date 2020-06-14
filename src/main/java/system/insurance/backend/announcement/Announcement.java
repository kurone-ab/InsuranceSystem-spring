package system.insurance.backend.announcement;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import system.insurance.backend.employee.Employee;

import javax.persistence.*;
import java.sql.Date;

@Slf4j
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 500)
    private String title;
    private Date date;
    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "author", referencedColumnName = "id")
    private Employee author;
    @Column(columnDefinition = "text")
    private String content;
    private boolean priority;

    @Builder
    public Announcement(String title, Date date, Employee author, String content, boolean priority) {
        this.title = title;
        this.date = date;
        this.author = author;
        this.content = content;
        this.priority = priority;
    }
}
