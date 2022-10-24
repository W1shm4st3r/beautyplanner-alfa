package git.w1shm4st3r.beautyplanner.bootstrap;

import git.w1shm4st3r.beautyplanner.model.Cosmetic;
import git.w1shm4st3r.beautyplanner.model.Ingredient;
import git.w1shm4st3r.beautyplanner.model.enums.CosmeticDestination;
import git.w1shm4st3r.beautyplanner.model.enums.CosmeticType;
import git.w1shm4st3r.beautyplanner.repository.CosmeticRepository;
import git.w1shm4st3r.beautyplanner.repository.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class CosmeticBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    final CosmeticRepository cosmeticRepository;

    final IngredientRepository ingredientRepository;

    public CosmeticBootstrap(CosmeticRepository cosmeticRepository, IngredientRepository ingredientRepository) {
        this.cosmeticRepository = cosmeticRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<Cosmetic> getCosmetics() {
        List<Cosmetic> cosmetics = new ArrayList<>();

        Cosmetic cosmetic = Cosmetic.builder()
                .name("Płyn do mycia")
                .price(10.99)
                .applicationsNumber(0)
                .destination(CosmeticDestination.BODY)
                .type(CosmeticType.CLEANER)
                .openingDate(LocalDate.now())
                .validityTerm(LocalDate.of(2023, 10, 1))
                .rate(8.5)
                .isFavourite(false)
                .isUsedUp(false)
                .build();

        Cosmetic cosmetic1 = Cosmetic.builder()
                .name("Krem pod oczy")
                .applicationsNumber(0)
                .price(14.88)
                .destination(CosmeticDestination.FACE)
                .type(CosmeticType.EYECREAM)
                .openingDate(LocalDate.now())
                .validityTerm(LocalDate.of(2023, 10, 1))
                .rate(6.5)
                .isFavourite(true)
                .isUsedUp(false)
                .build();

        Cosmetic cosmetic2 = Cosmetic.builder()
                .name("Maseczka")
                .applicationsNumber(0)
                .price(21.37)
                .destination(CosmeticDestination.FACE)
                .type(CosmeticType.MASK)
                .openingDate(LocalDate.now())
                .validityTerm(LocalDate.of(2023, 10, 1))
                .rate(9.37)
                .isFavourite(false)
                .isUsedUp(false)
                .build();

        Cosmetic cosmetic3 = Cosmetic.builder()
                .name("Szampon")
                .applicationsNumber(0)
                .price(49.99)
                .destination(CosmeticDestination.HAIR)
                .type(CosmeticType.SHAMPOO)
                .openingDate(LocalDate.now())
                .validityTerm(LocalDate.of(2023, 10, 1))
                .rate(8.0)
                .isFavourite(true)
                .isUsedUp(false)
                .build();


        cosmetics.add(cosmetic);
        cosmetics.add(cosmetic1);
        cosmetics.add(cosmetic2);
        cosmetics.add(cosmetic3);

        return cosmetics;
    }

    List<Ingredient> getIngredients() {
        Ingredient ingredient = Ingredient.builder()
                .name("Aqua")
                .description("Water, base for cosmetics")
                .build();

        Ingredient ingredient1 = Ingredient.builder()
                .name("Glycerin")
                .description("Humectant, moisture")
                .build();

        return List.of(ingredient, ingredient1);
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        cosmeticRepository.deleteAll();
        cosmeticRepository.saveAll(getCosmetics());
        ingredientRepository.deleteAll();
        ingredientRepository.saveAll(getIngredients());
        log.info("---Loading bootstrap data---");
    }
}
