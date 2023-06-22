package sia.tacos.data;

import org.springframework.data.repository.CrudRepository;
import sia.tacos.model.Ingredient;

public interface IngredientsRepository extends CrudRepository<Ingredient, Long> {
}
