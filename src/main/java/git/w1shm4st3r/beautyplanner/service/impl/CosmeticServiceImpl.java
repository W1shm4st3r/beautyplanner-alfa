package git.w1shm4st3r.beautyplanner.service.impl;

import git.w1shm4st3r.beautyplanner.dto.CosmeticDto;
import git.w1shm4st3r.beautyplanner.mapper.CosmeticMapper;
import git.w1shm4st3r.beautyplanner.model.Cosmetic;
import git.w1shm4st3r.beautyplanner.repository.CosmeticRepository;
import git.w1shm4st3r.beautyplanner.service.CosmeticService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public List<Cosmetic> getAllCosmeticsSortedByDestination() {
        List<Cosmetic> cosmetics = cosmeticRepository.findAll(Sort.by(ASC, "destination"));
        List<Cosmetic> currentlyUsed = new ArrayList<>();
        for (Cosmetic cosmetic : cosmetics) {
            if (!cosmetic.getIsUsedUp() && !cosmetic.getIsWished()) {
                currentlyUsed.add(cosmetic);
            }
        }
        return currentlyUsed;
    }

    @Override
    public Cosmetic getCosmeticById(Long cosmeticId) {
        return cosmeticRepository.findCosmeticById(cosmeticId);
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

    @Override
    public void deleteCosmetic(Long cosmeticId) {
        cosmeticRepository.deleteById(cosmeticId);
    }

    @Override
    public void addCosmetic(CosmeticDto cosmeticDto) {
        Cosmetic cosmetic = CosmeticMapper.mapToCosmetic(cosmeticDto);
        cosmetic.setIsWished(false);
        cosmeticRepository.save(cosmetic);
    }

    @Override
    public void addToUsedUp(Long cosmeticId) {
        Cosmetic usedUpCosmetic = cosmeticRepository.findCosmeticById(cosmeticId);
        usedUpCosmetic.setIsUsedUp(true);
        usedUpCosmetic.setDateOfUsingUp(LocalDate.now());
        cosmeticRepository.save(usedUpCosmetic);
    }

    @Override
    public List<Cosmetic> getUsedUp() {
        List<Cosmetic> cosmetics = cosmeticRepository.findAll(Sort.by(DESC, "dateOfUsingUp"));
        List<Cosmetic> usedUpCosmetics = new ArrayList<>();
        for (Cosmetic cosmetic : cosmetics) {
            if (cosmetic.getIsUsedUp() && !cosmetic.getIsWished()) {
                usedUpCosmetics.add(cosmetic);
            }
        }
        return usedUpCosmetics;
    }

    @Override
    public void removeFromUsedUp(Long cosmeticId) {
        Cosmetic cosmeticToRemove = cosmeticRepository.findCosmeticById(cosmeticId);
        cosmeticToRemove.setIsUsedUp(false);
        cosmeticToRemove.setDateOfUsingUp(null);
        cosmeticRepository.save(cosmeticToRemove);
    }

    @Override
    public void increaseApplications(Long cosmeticId) {
        Cosmetic cosmetic = cosmeticRepository.findCosmeticById(cosmeticId);
        cosmetic.setApplicationsNumber(cosmetic.getApplicationsNumber() + 1);
        cosmeticRepository.save(cosmetic);
    }

    @Override
    public void decreaseApplications(Long cosmeticId) {
        Cosmetic cosmetic = cosmeticRepository.findCosmeticById(cosmeticId);
        if (cosmetic.getApplicationsNumber() > 0) {
            cosmetic.setApplicationsNumber(cosmetic.getApplicationsNumber() - 1);
            cosmeticRepository.save(cosmetic);
        }
    }

    @Override
    public void updateCosmetic(CosmeticDto cosmetic) {
        cosmeticRepository.save(CosmeticMapper.mapToCosmetic(cosmetic));
    }

    @Override
    public List<Cosmetic> getWished() {
        List<Cosmetic> cosmetics = cosmeticRepository.findAll(Sort.by(ASC, "destination"));
        List<Cosmetic> wishedCosmetics = new ArrayList<>();
        for (Cosmetic cosmetic : cosmetics) {
            if (cosmetic.getIsWished()) {
                wishedCosmetics.add(cosmetic);
            }
        }
        return wishedCosmetics;
    }

    @Override
    public void addWishedCosmetic(CosmeticDto cosmeticDto) {
        Cosmetic cosmetic = CosmeticMapper.mapToCosmetic(cosmeticDto);
        cosmetic.setIsWished(true);
        cosmeticRepository.save(cosmetic);
    }

    @Override
    public void moveWishedToCollection(Long cosmeticId) {
        Cosmetic boughtCosmetic = cosmeticRepository.findCosmeticById(cosmeticId);
        boughtCosmetic.setIsWished(false);
        cosmeticRepository.save(boughtCosmetic);
    }

    @Override
    public void moveToWishList(Long cosmeticId) {
        Cosmetic cosmetic = cosmeticRepository.findCosmeticById(cosmeticId);
        cosmetic.setIsWished(true);
        cosmeticRepository.save(cosmetic);
    }

}
