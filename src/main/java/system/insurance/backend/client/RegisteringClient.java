package system.insurance.backend.client;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("REGISTERING")
public class RegisteringClient extends Client{

}
