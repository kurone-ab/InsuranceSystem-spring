package system.insurance.backend.strategy;

import lombok.Getter;
import system.insurance.backend.insurance.Insurance;

import javax.persistence.*;
import javax.persistence.criteria.Join;

@Entity
@Getter
public class Strategy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(targetEntity = Insurance.class)
    @JoinColumn(name = "popular", referencedColumnName = "id")
    private Insurance popular;
}
