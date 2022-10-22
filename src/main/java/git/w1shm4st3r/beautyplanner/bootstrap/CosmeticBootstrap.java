package git.w1shm4st3r.beautyplanner.bootstrap;

import git.w1shm4st3r.beautyplanner.dto.CosmeticDto;
import git.w1shm4st3r.beautyplanner.model.Cosmetic;
import git.w1shm4st3r.beautyplanner.model.enums.CosmeticDestination;
import git.w1shm4st3r.beautyplanner.model.enums.CosmeticType;
import git.w1shm4st3r.beautyplanner.repository.CosmeticRepository;
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

    public CosmeticBootstrap(CosmeticRepository cosmeticRepository) {
        this.cosmeticRepository = cosmeticRepository;
    }

    public List<Cosmetic> getCosmetics() {
        List<Cosmetic> cosmetics = new ArrayList<>();

        Cosmetic cosmetic = Cosmetic.builder()
                .name("Płyn do mycia")
                .price(10.99)
                .destination(CosmeticDestination.BODY)
                .type(CosmeticType.CLEANER)
                .openingDate(LocalDate.now())
                .validityTerm(LocalDate.of(2023, 10, 1))
                .rate(8.5)
                .build();

        Cosmetic cosmetic1 = Cosmetic.builder()
                .name("Krem pod oczy")
                .price(14.88)
                .destination(CosmeticDestination.FACE)
                .type(CosmeticType.EYECREAM)
                .openingDate(LocalDate.now())
                .validityTerm(LocalDate.of(2023, 10, 1))
                .rate(6.5)
                .build();

        Cosmetic cosmetic2 = Cosmetic.builder()
                .name("Maseczka")
                .price(21.37)
                .destination(CosmeticDestination.FACE)
                .type(CosmeticType.MASK)
                .openingDate(LocalDate.now())
                .validityTerm(LocalDate.of(2023, 10, 1))
                .rate(9.37)
                .build();

        Cosmetic cosmetic3 = Cosmetic.builder()
                .name("Szampon")
                .price(49.99)
                .destination(CosmeticDestination.HAIR)
                .type(CosmeticType.SHAMPOO)
                .openingDate(LocalDate.now())
                .validityTerm(LocalDate.of(2023, 10, 1))
                .rate(8.0)
                .build();


        cosmetics.add(cosmetic);
        cosmetics.add(cosmetic1);
        cosmetics.add(cosmetic2);
        cosmetics.add(cosmetic3);

        return cosmetics;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        cosmeticRepository.deleteAll();
        cosmeticRepository.saveAll(getCosmetics());
        log.info("---Loading bootstrap data---");
    }
}
