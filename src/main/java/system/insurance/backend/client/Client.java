package system.insurance.backend.client;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 15)
    private String contact;
    private int age;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Column(length = 30)
    private String name;
    @Column(length = 30)
    private String email;
    @Enumerated(EnumType.STRING)
    private ClientType type;
}
