package git.w1shm4st3r.beautyplanner.controller;

import git.w1shm4st3r.beautyplanner.model.Cosmetic;
import git.w1shm4st3r.beautyplanner.service.CosmeticService;
import git.w1shm4st3r.beautyplanner.service.impl.CosmeticServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RankingController {

    private final CosmeticService cosmeticService;

    public RankingController(CosmeticServiceImpl cosmeticService) {
        this.cosmeticService = cosmeticService;
    }

    @GetMapping("ranking")
    public String displayRanking(Model model) {
        List<Cosmetic> cosmeticsSorted = cosmeticService.getAllCosmeticsSortedByRate();
        List<Cosmetic> cosmeticsRanked = new ArrayList<>();
        for (Cosmetic cosmetic : cosmeticsSorted) {
            if (cosmetic.getRate() != null) {
                cosmeticsRanked.add(cosmetic);
            }
        }
        model.addAttribute("cosmeticsRanked", cosmeticsRanked);
        return "ranking";
    }
}
