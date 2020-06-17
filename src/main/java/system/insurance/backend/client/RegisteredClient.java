package system.insurance.backend.client;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("REGISTERED")
public class RegisteredClient extends Client{
}
