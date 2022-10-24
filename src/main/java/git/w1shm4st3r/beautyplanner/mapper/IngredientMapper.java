package git.w1shm4st3r.beautyplanner.mapper;

import git.w1shm4st3r.beautyplanner.dto.IngredientDto;
import git.w1shm4st3r.beautyplanner.model.Ingredient;

public class IngredientMapper {

    public static Ingredient mapToIngredient(IngredientDto ingredientDto) {
        return new Ingredient(
                ingredientDto.getId(),
                ingredientDto.getName(),
                ingredientDto.getDescription()
        );
    }

    public static IngredientDto mapToIngredientDto(Ingredient ingredient) {
        return new IngredientDto(
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getDescription()
        );
    }

}
