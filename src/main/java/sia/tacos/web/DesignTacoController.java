package sia.tacos.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sia.tacos.model.Ingredient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import sia.tacos.model.Ingredient.Type;
import sia.tacos.model.Taco;


@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model) {
        addIngredientsList(model);
        model.addAttribute("design", new Taco());
        return "design";
    }

    private Model addIngredientsList(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "pszenna", Ingredient.Type.WRAP),
                new Ingredient("COTO", "kukurydziana", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "mielona wołowina", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "kawałek mięsa", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "pomidory pokrojone w kostkę", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "sałata", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "Monterey Jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "pikantny sos pomidorowy", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "śmietana", Ingredient.Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        return model;
    }

    private List<Object> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(i -> type.equals(i.getType()))
                .collect(Collectors.toList());
    }


    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, Model model) {
        if (errors.hasErrors()) {
            log.error("Design form has validation errors: {}", errors.getAllErrors());
            addIngredientsList(model);
            return "design";
        }

        log.info("Przetwarzanie projektu taco: {}...", design);
        return "redirect:/orders/current";
    }

}
