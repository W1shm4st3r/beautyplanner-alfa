package git.w1shm4st3r.beautyplanner.controller;

import git.w1shm4st3r.beautyplanner.model.Ingredient;
import git.w1shm4st3r.beautyplanner.service.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/ingredients")
    public String getIngredients(Model model) {
        List<Ingredient> ingredients = ingredientService.getAllIngredientsSortedByName();
        return "ingredient/ingredients";
    }
}
