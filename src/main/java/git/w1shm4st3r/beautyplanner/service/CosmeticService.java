package git.w1shm4st3r.beautyplanner.service;

import git.w1shm4st3r.beautyplanner.dto.CosmeticDto;
import git.w1shm4st3r.beautyplanner.model.Cosmetic;

import java.util.List;

public interface CosmeticService {
    List<Cosmetic> getAllCosmetics();
    List<Cosmetic> getAllCosmeticsSortedByRate();
    List<Cosmetic> getAllCosmeticsSortedByType();
    Cosmetic getCosmeticById(Long cosmeticId);
    void addToFavourites(Long cosmeticId);
    void removeFromFavourites(Long cosmeticId);
    void deleteCosmetic(Long cosmeticId);
    void addCosmetic(CosmeticDto cosmeticDto);
}
