package spencer.springframework.petclinic.services;
import spencer.springframework.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastname(String lastName);
}
