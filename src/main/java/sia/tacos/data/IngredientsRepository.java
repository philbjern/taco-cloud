package sia.tacos.data;

import sia.tacos.model.Ingredient;

public interface IngredientsRepository {
    Iterable<Ingredient> findAll();
    Ingredient findById(String id);
    Ingredient save(Ingredient ingredient);
}
