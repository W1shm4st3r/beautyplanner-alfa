package git.w1shm4st3r.beautyplanner.mapper;

import git.w1shm4st3r.beautyplanner.dto.CosmeticDto;
import git.w1shm4st3r.beautyplanner.model.Cosmetic;

public class CosmeticMapper {

    public static CosmeticDto mapToCosmeticDto(Cosmetic cosmetic) {
        CosmeticDto cosmeticDto = new CosmeticDto(
                cosmetic.getId(),
                cosmetic.getName(),
                cosmetic.getPrice(),
                cosmetic.getDestination(),
                cosmetic.getType(),
                cosmetic.getOpeningDate(),
                cosmetic.getValidityTerm(),
                cosmetic.getRate(),
                cosmetic.getApplicationsNumber(),
                cosmetic.getIsFavourite(),
                cosmetic.getIsUsedUp()
        );
        return cosmeticDto;
    }

    public static Cosmetic mapToCosmetic(CosmeticDto cosmeticDto) {
        Cosmetic cosmetic = new Cosmetic(
                cosmeticDto.getId(),
                cosmeticDto.getName(),
                cosmeticDto.getPrice(),
                cosmeticDto.getDestination(),
                cosmeticDto.getType(),
                cosmeticDto.getOpeningDate(),
                cosmeticDto.getValidityTerm(),
                cosmeticDto.getRate(),
                cosmeticDto.getApplicationsNumber(),
                cosmeticDto.getIsFavourite(),
                cosmeticDto.getIsUsedUp()
        );
        return cosmetic;
    }

}
