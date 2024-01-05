package tacos;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
public interface IngredientRepository
            extends ReactiveCrudRepository<Ingredient, String> {

}
