package git.w1shm4st3r.beautyplanner.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto {
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    private String description;
}
