package git.w1shm4st3r.beautyplanner.controller;

import git.w1shm4st3r.beautyplanner.dto.CosmeticDto;
import git.w1shm4st3r.beautyplanner.model.Cosmetic;
import git.w1shm4st3r.beautyplanner.service.CosmeticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CosmeticController {
    private final CosmeticService cosmeticService;

    public CosmeticController(CosmeticService cosmeticService) {
        this.cosmeticService = cosmeticService;
    }

    @GetMapping("cosmetics")
    public String getCosmeticList(Model model) {
        List<Cosmetic> cosmetics = cosmeticService.getAllCosmeticsSortedByType();
        model.addAttribute("cosmetics", cosmetics);
        return "cosmetic/cosmetics";
    }

    @GetMapping("/cosmetics/new")
    public String getAddingForm(Model model) {
        CosmeticDto cosmetic = new CosmeticDto();
        model.addAttribute("cosmetic", cosmetic);
        return "cosmetic/add-cosmetic";
    }

}
