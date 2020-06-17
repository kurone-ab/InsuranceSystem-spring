package system.insurance.backend.client;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EnvironmentalFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Job job;
    private String dangerousHobby;
    @Column(columnDefinition = "POINT")
    private Point residence;
    private String dangerousArea;

    public EnvironmentalFactor(Job job, String dangerousHobby, Point residence, String dangerousArea) {
        this.job = job;
        this.dangerousHobby = dangerousHobby;
        this.residence = residence;
        this.dangerousArea = dangerousArea;
    }
}
