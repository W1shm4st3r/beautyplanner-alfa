package git.w1shm4st3r.beautyplanner.model;

import git.w1shm4st3r.beautyplanner.model.enums.CosmeticDestination;
import git.w1shm4st3r.beautyplanner.model.enums.CosmeticType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "cosmetic")
public class Cosmetic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cosmetic_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "destination")
    private CosmeticDestination destination;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CosmeticType type;

    @Column(name = "opening_date")
    private LocalDate openingDate;

    @Column(name = "validity_term")
    private LocalDate validityTerm;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "applications_number")
    private Integer applicationsNumber;

    @Column(name = "is_favourite")
    private Boolean isFavourite = false;

    @Column(name = "is_used_up")
    private Boolean isUsedUp = false;
}
