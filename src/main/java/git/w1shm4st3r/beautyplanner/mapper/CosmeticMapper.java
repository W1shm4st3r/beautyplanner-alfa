package git.w1shm4st3r.beautyplanner.mapper;

import git.w1shm4st3r.beautyplanner.dto.CosmeticDto;
import git.w1shm4st3r.beautyplanner.model.Cosmetic;

public class CosmeticMapper {

    public static CosmeticDto mapToCosmeticDto(Cosmetic cosmetic) {
        return new CosmeticDto(
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
                cosmetic.getIsUsedUp(),
                cosmetic.getDateOfUsingUp(),
                cosmetic.getIsWished()
        );
    }

    public static Cosmetic mapToCosmetic(CosmeticDto cosmeticDto) {
        return new Cosmetic(
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
                cosmeticDto.getIsUsedUp(),
                cosmeticDto.getDateOfUsingUp(),
                cosmeticDto.getIsWished()
        );
    }

}
