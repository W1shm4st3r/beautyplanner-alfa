package git.w1shm4st3r.beautyplanner.controller;

import git.w1shm4st3r.beautyplanner.dto.IngredientDto;
import git.w1shm4st3r.beautyplanner.model.Ingredient;
import git.w1shm4st3r.beautyplanner.service.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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
        model.addAttribute("ingredients", ingredients);
        return "ingredient/ingredients";
    }

    @GetMapping("/ingredients/new")
    public String getAddingForm(Model model) {
        IngredientDto ingredient = new IngredientDto();
        model.addAttribute("ingredient", ingredient);
        return "ingredient/add-ingredient";
    }

    @PostMapping("/ingredients")
    public String addIngredient(@Valid @ModelAttribute("ingredient") IngredientDto ingredient,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ingredient", ingredient);
            return "ingredient/add-ingredient";
        }
        ingredientService.addIngredient(ingredient);
        return "redirect:/ingredients";
    }

    @GetMapping("/ingredients/{ingredientId}/delete")
    public String deleteIngredient(@PathVariable("ingredientId") Long ingredientId) {
        ingredientService.deleteIngredient(ingredientId);
        return "redirect:/ingredients";
    }

    @GetMapping("ingredients/{ingredientId}/edit")
    public String getEditForm(@PathVariable("ingredientId") Long ingredientId, Model model) {
        Ingredient ingredient = ingredientService.getIngredientById(ingredientId);
        model.addAttribute("ingredient", ingredient);
        return "ingredient/edit-ingredient";
    }

    @PostMapping("ingredients/{ingredientId}/update")
    public String updateIngredient(@PathVariable("ingredientId") Long ingredientId,
                                   @Valid @ModelAttribute IngredientDto ingredient, BindingResult result, Model model) {
        Ingredient ingredientToEdit = ingredientService.getIngredientById(ingredientId);
        if (result.hasErrors()) {
            model.addAttribute("ingredient", ingredient);
            return "ingredient/edit-ingredient";
        }
        ingredient.setId(ingredientToEdit.getId());
        ingredientService.updateIngredient(ingredient);
        return "redirect:/ingredients";
    }

}
