package git.w1shm4st3r.beautyplanner.controller;

import git.w1shm4st3r.beautyplanner.model.Cosmetic;
import git.w1shm4st3r.beautyplanner.service.CosmeticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UsedUpController {

    private final CosmeticService cosmeticService;

    public UsedUpController(CosmeticService cosmeticService) {
        this.cosmeticService = cosmeticService;
    }

    @GetMapping("/usedUp")
    public String getUsedUp(Model model) {
        List<Cosmetic> usedUpCosmetics = cosmeticService.getUsedUp();
        model.addAttribute("usedUpCosmetics", usedUpCosmetics);
        return "used-up";
    }

    @GetMapping("/usedUp/{cosmeticId}/delete")
    public String deleteCosmetic(@PathVariable("cosmeticId") Long cosmeticId) {
        cosmeticService.deleteCosmetic(cosmeticId);
        return "redirect:/usedUp";
    }

    @GetMapping("/usedUp/{cosmeticId}/addToFavourites")
    public String addToFavourites(@PathVariable("cosmeticId") Long cosmeticId) {
        cosmeticService.addToFavourites(cosmeticId);
        return "redirect:/usedUp";
    }

    @GetMapping("/usedUp/{cosmeticId}/removeFromUsedUp")
    public String removeFromUsedUp(@PathVariable("cosmeticId") Long cosmeticId) {
        cosmeticService.removeFromUsedUp(cosmeticId);
        return "redirect:/usedUp";
    }

}
