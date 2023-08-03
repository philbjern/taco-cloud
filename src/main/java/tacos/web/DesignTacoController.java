package tacos.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacos.data.IngredientsRepository;
import tacos.data.TacoRepository;
import tacos.model.Ingredient;
import tacos.model.Ingredient.Type;
import tacos.model.TacoOrder;
import tacos.model.Taco;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    private IngredientsRepository ingredientsRepository;
    private TacoRepository designRepo;

    @Autowired
    public DesignTacoController(IngredientsRepository ingredientsRepository,
                                TacoRepository designRepo) {
        this.ingredientsRepository = ingredientsRepository;
        this.designRepo = designRepo;
    }

    @GetMapping
    public String showDesignForm(Model model) {
        return "design";
    }

    @ModelAttribute
    private void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientsRepository.findAll().forEach(ingredients::add);

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    private List<Object> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(i -> type.equals(i.getType()))
                .collect(Collectors.toList());
    }

    @ModelAttribute("tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute("taco")
    public Taco taco() {
        return new Taco();
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
//        List<Ingredient> designIngredients = Arrays.asList(ingredientArray);
//        Taco taco = (Taco) model.getAttribute("taco");
//        design.setIngredients(designIngredients);

        if (errors.hasErrors()) {
            log.error("Design form has validation errors: {}", errors.getAllErrors());
//            addIngredientsToModel(model);
            return "design";
        }

        log.info("Przetwarzanie projektu taco: {}...", taco);
//        Taco saved = designRepo.save(taco);
        tacoOrder.addDesign(taco);

        return "redirect:/orders/current";
    }

}
