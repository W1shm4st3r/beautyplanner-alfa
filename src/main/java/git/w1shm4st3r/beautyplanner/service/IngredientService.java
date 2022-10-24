package git.w1shm4st3r.beautyplanner.service;

import git.w1shm4st3r.beautyplanner.dto.IngredientDto;
import git.w1shm4st3r.beautyplanner.model.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredientsSortedByName();
    void addIngredient(IngredientDto ingredient);
    void deleteIngredient(Long ingredientId);
    Ingredient getIngredientById(Long ingredientId);
    void updateIngredient(IngredientDto ingredient);
}
