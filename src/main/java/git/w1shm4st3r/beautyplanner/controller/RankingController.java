package git.w1shm4st3r.beautyplanner.controller;

import git.w1shm4st3r.beautyplanner.model.Cosmetic;
import git.w1shm4st3r.beautyplanner.service.CosmeticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RankingController {

    private final CosmeticService cosmeticService;

    public RankingController(CosmeticService cosmeticService) {
        this.cosmeticService = cosmeticService;
    }

    @GetMapping("ranking")
    public String displayRanking(Model model) {
        List<Cosmetic> cosmeticsSorted = cosmeticService.getAllCosmeticsSortedByRate();
        model.addAttribute("cosmeticsSorted", cosmeticsSorted);
        return "cosmetic/ranking";
    }
}
