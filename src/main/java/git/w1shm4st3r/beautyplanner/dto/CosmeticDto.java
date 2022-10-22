package git.w1shm4st3r.beautyplanner.dto;

import git.w1shm4st3r.beautyplanner.model.enums.CosmeticDestination;
import git.w1shm4st3r.beautyplanner.model.enums.CosmeticType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CosmeticDto {
    private Long id;
    private String name;
    private Double price;
    private CosmeticDestination destination;
    private CosmeticType type;
    private LocalDate openingDate;
    private LocalDate validityTerm;
    private Double rate;
    private Integer applicationsNumber;
    private Boolean isFavourite = false;
    private Boolean isUsedUp = false;
}
