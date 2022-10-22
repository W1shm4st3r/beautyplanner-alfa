package git.w1shm4st3r.beautyplanner.service;

import git.w1shm4st3r.beautyplanner.model.Cosmetic;
import git.w1shm4st3r.beautyplanner.repository.CosmeticRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
@Transactional
public class CosmeticService {

    private final CosmeticRepository cosmeticRepository;

    public CosmeticService(CosmeticRepository cosmeticRepository) {
        this.cosmeticRepository = cosmeticRepository;
    }

    public List<Cosmetic> getAllCosmetics() {
        return cosmeticRepository.findAll();
    }

    public List<Cosmetic> getAllCosmeticsSortedByRate() {
        return cosmeticRepository.findAll(Sort.by(DESC, "rate"));
    }

    public List<Cosmetic> getAllCosmeticsSortedByType() {
        return cosmeticRepository.findAll(Sort.by(ASC, "type"));
    }

    public Cosmetic getCosmeticById(Long id) {
        return cosmeticRepository.findCosmeticById(id);
    }

    public Cosmetic addCosmetic(Cosmetic cosmetic) {
        return cosmeticRepository.save(cosmetic);
    }

    public Cosmetic updateCosmetic(Cosmetic cosmetic) {
        return cosmeticRepository.save(cosmetic);
    }

    @Transactional
    public void deleteCosmeticById(Long id) {
        cosmeticRepository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        cosmeticRepository.deleteAll();
    }

}
