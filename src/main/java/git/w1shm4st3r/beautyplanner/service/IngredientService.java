package git.w1shm4st3r.beautyplanner.service;

import git.w1shm4st3r.beautyplanner.model.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getAllIngredientsSortedByName();
}
