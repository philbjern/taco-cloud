package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.model.TacoCloudUser;

public interface UserRepository extends CrudRepository<TacoCloudUser, Long> {

    TacoCloudUser findByUsername(String username);

}
