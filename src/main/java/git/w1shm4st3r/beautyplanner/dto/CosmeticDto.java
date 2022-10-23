package git.w1shm4st3r.beautyplanner.dto;

import git.w1shm4st3r.beautyplanner.model.enums.CosmeticDestination;
import git.w1shm4st3r.beautyplanner.model.enums.CosmeticType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CosmeticDto {
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    private Double price;
    private CosmeticDestination destination;
    private CosmeticType type;
    private LocalDate openingDate;
    private LocalDate validityTerm;
    private Double rate;
    private Integer applicationsNumber = 0;
    private Boolean isFavourite = false;
    private Boolean isUsedUp = false;
    private LocalDate dateOfUsingUp;
}
