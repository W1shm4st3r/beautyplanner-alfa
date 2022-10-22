package git.w1shm4st3r.beautyplanner.repository;

import git.w1shm4st3r.beautyplanner.model.Cosmetic;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CosmeticRepository extends JpaRepository<Cosmetic, Long> {
    Cosmetic findCosmeticById(Long cosmeticId);
    List<Cosmetic> findAll(Sort sort);
}
