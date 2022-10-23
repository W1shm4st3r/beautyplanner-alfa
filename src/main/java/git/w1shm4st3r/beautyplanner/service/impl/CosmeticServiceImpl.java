package git.w1shm4st3r.beautyplanner.service.impl;

import git.w1shm4st3r.beautyplanner.dto.CosmeticDto;
import git.w1shm4st3r.beautyplanner.mapper.CosmeticMapper;
import git.w1shm4st3r.beautyplanner.model.Cosmetic;
import git.w1shm4st3r.beautyplanner.repository.CosmeticRepository;
import git.w1shm4st3r.beautyplanner.service.CosmeticService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;
import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
@Transactional
public class CosmeticServiceImpl implements CosmeticService {

    private final CosmeticRepository cosmeticRepository;

    public CosmeticServiceImpl(CosmeticRepository cosmeticRepository) {
        this.cosmeticRepository = cosmeticRepository;
    }

    @Override
    public List<Cosmetic> getAllCosmetics() {
        return cosmeticRepository.findAll();
    }

    @Override
    public List<Cosmetic> getAllCosmeticsSortedByRate() {
        return cosmeticRepository.findAll(Sort.by(DESC, "rate"));
    }

    @Override
    public List<Cosmetic> getAllCosmeticsSortedByType() {
        return cosmeticRepository.findAll(Sort.by(ASC, "type"));
    }

    @Override
    public Cosmetic getCosmeticById(Long id) {
        return cosmeticRepository.findCosmeticById(id);
    }

    @Override
    public void addToFavourites(Long cosmeticId) {
        Cosmetic cosmeticToAdd = cosmeticRepository.findCosmeticById(cosmeticId);
        cosmeticToAdd.setIsFavourite(true);
        cosmeticRepository.save(cosmeticToAdd);
    }

    @Override
    public void removeFromFavourites(Long cosmeticId) {
        Cosmetic cosmeticToRemove = cosmeticRepository.findCosmeticById(cosmeticId);
        cosmeticToRemove.setIsFavourite(false);
        cosmeticRepository.save(cosmeticToRemove);
    }

//    public Cosmetic addCosmetic(Cosmetic cosmetic) {
//        return cosmeticRepository.save(cosmetic);
//    }
//
//    public Cosmetic updateCosmetic(Cosmetic cosmetic) {
//        return cosmeticRepository.save(cosmetic);
//    }
//
//    @Transactional
//    public void deleteCosmeticById(Long id) {
//        cosmeticRepository.deleteById(id);
//    }
//
//    @Transactional
//    public void deleteAll() {
//        cosmeticRepository.deleteAll();
//    }

}
