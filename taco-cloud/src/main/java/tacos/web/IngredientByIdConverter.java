package tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tacos.data.IngredientsRepository;
import tacos.model.Ingredient;


@Component
public class IngredientByIdConverter  implements Converter<String, Ingredient> {

    private IngredientsRepository ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientsRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(String source) {
        return ingredientRepo.findById(source).orElse(null);
    }
}
