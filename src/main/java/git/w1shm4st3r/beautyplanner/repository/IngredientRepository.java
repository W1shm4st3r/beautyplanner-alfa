package git.w1shm4st3r.beautyplanner.repository;

import git.w1shm4st3r.beautyplanner.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Ingredient findIngredientById(Long ingredientId);
}

