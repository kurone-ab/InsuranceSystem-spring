package system.insurance.backend.client;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("NOT_REGISTERED")
public class NotRegisteredClient extends Client {
    private String gift;
}
