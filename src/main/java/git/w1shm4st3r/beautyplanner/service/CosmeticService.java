package git.w1shm4st3r.beautyplanner.service;

import git.w1shm4st3r.beautyplanner.dto.CosmeticDto;
import git.w1shm4st3r.beautyplanner.model.Cosmetic;

import java.util.List;

public interface CosmeticService {
    List<Cosmetic> getAllCosmetics();
    List<Cosmetic> getAllCosmeticsSortedByRate();
    List<Cosmetic> getAllCosmeticsSortedByType();
    Cosmetic getCosmeticById(Long id);
    void addToFavourites(Long id);
    void removeFromFavourites(Long id);
}
