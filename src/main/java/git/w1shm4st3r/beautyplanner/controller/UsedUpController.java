package git.w1shm4st3r.beautyplanner.controller;

import git.w1shm4st3r.beautyplanner.dto.CosmeticDto;
import git.w1shm4st3r.beautyplanner.mapper.CosmeticMapper;
import git.w1shm4st3r.beautyplanner.model.Cosmetic;
import git.w1shm4st3r.beautyplanner.service.CosmeticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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

    @GetMapping("/usedUp/{cosmeticId}/edit")
    public String editCosmetic(@PathVariable("cosmeticId") Long cosmeticId, Model model) {
        Cosmetic cosmetic = cosmeticService.getCosmeticById(cosmeticId);
        model.addAttribute("cosmetic", cosmetic);
        return "cosmetic/edit-used-up";
    }

    @PostMapping("/usedUp/{cosmeticId}/update")
    public String updateCosmetic(@PathVariable("cosmeticId") Long cosmeticId, @Valid @ModelAttribute CosmeticDto cosmetic,
                                 BindingResult result, Model model) {
        Cosmetic cosmeticToEdit = cosmeticService.getCosmeticById(cosmeticId);
        if (result.hasErrors()) {
            model.addAttribute("cosmetic", cosmetic);
            return "cosmetic/edit-used-up";
        }
        cosmetic.setId(cosmeticId);
        cosmetic.setIsFavourite(cosmeticToEdit.getIsFavourite());
        cosmetic.setIsUsedUp(cosmeticToEdit.getIsUsedUp());
        cosmetic.setIsWished(cosmeticToEdit.getIsWished());
        cosmeticService.updateCosmetic(cosmetic);
        return "redirect:/usedUp";
    }

    @GetMapping("/usedUp/{cosmeticId}/increaseApplications")
    public String increaseApplications(@PathVariable("cosmeticId") Long cosmeticId) {
        cosmeticService.increaseApplications(cosmeticId);
        return "redirect:/usedUp";
    }

    @GetMapping("/usedUp/{cosmeticId}/decreaseApplications")
    public String decreaseApplications(@PathVariable("cosmeticId") Long cosmeticId) {
        cosmeticService.decreaseApplications(cosmeticId);
        return "redirect:/usedUp";
    }

    @GetMapping("/usedUp/{cosmeticId}/cosmeticDetails")
    public String displayCosmeticDetails(@PathVariable("cosmeticId") Long cosmeticId, Model model) {
        CosmeticDto cosmetic = CosmeticMapper.mapToCosmeticDto(cosmeticService.getCosmeticById(cosmeticId));
        model.addAttribute("cosmetic", cosmetic);
        return "cosmetic/view-cosmetic";
    }

}
