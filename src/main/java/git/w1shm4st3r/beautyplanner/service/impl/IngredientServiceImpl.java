package git.w1shm4st3r.beautyplanner.service.impl;

import git.w1shm4st3r.beautyplanner.dto.IngredientDto;
import git.w1shm4st3r.beautyplanner.mapper.IngredientMapper;
import git.w1shm4st3r.beautyplanner.model.Ingredient;
import git.w1shm4st3r.beautyplanner.repository.IngredientRepository;
import git.w1shm4st3r.beautyplanner.service.IngredientService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;

@Service
@Transactional
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAllIngredientsSortedByName() {
        return ingredientRepository.findAll(Sort.by(ASC, "name"));
    }

    @Override
    public void addIngredient(IngredientDto ingredient) {
        ingredientRepository.save(IngredientMapper.mapToIngredient(ingredient));
    }

    @Override
    public void deleteIngredient(Long ingredientId) {
        ingredientRepository.deleteById(ingredientId);
    }

    @Override
    public Ingredient getIngredientById(Long ingredientId) {
        return ingredientRepository.findIngredientById(ingredientId);
    }

    @Override
    public void updateIngredient(IngredientDto ingredient) {
        ingredientRepository.save(IngredientMapper.mapToIngredient(ingredient));
    }

}
