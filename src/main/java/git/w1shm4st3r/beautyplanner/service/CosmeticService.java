package git.w1shm4st3r.beautyplanner.service;

import git.w1shm4st3r.beautyplanner.dto.CosmeticDto;
import git.w1shm4st3r.beautyplanner.model.Cosmetic;

import java.util.List;

public interface CosmeticService {
    List<Cosmetic> getAllCosmetics();
    List<Cosmetic> getAllCosmeticsSortedByRate();
    List<Cosmetic> getAllCosmeticsSortedByDestination();
    Cosmetic getCosmeticById(Long cosmeticId);
    void addToFavourites(Long cosmeticId);
    void removeFromFavourites(Long cosmeticId);
    void deleteCosmetic(Long cosmeticId);
    void addCosmetic(CosmeticDto cosmeticDto);
    void addToUsedUp(Long cosmeticId);
    List<Cosmetic> getUsedUp();
    void removeFromUsedUp(Long cosmeticId);
    void increaseApplications(Long cosmeticId);
    void decreaseApplications(Long cosmeticId);
    void updateCosmetic(CosmeticDto cosmetic);
    List<Cosmetic> getWished();
    void addWishedCosmetic(CosmeticDto cosmeticDto);
    void moveWishedToCollection(Long cosmeticId);
    void moveToWishList(Long cosmeticId);
//    void updateWished(CosmeticDto wishedToEdit);
}
