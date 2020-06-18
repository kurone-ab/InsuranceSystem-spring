package system.insurance.backend.client;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DiscriminatorValue("NOT_REGISTERED")
public class NotRegisteredClient extends Client {
    private String gift;

    public NotRegisteredClient(String gift) {
    }
}
