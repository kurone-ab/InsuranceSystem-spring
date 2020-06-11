package system.insurance.backend.employee;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import system.insurance.backend.client.Sex;

import javax.persistence.*;
import java.io.Serializable;


@Slf4j
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String uid;
    private String password;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String name;
    private String phoneNum;
    @Enumerated(EnumType.STRING)
    private Authority authority;
    private String dutyResponsibility;

    @Builder
    public Employee(String uid, String password, String name, int age, Sex sex, String phoneNum, Authority authority, String dutyResponsibility) {
        this.uid = uid;
        this.password = password;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phoneNum = phoneNum;
        this.authority = authority;
        this.dutyResponsibility = dutyResponsibility;
    }
}
