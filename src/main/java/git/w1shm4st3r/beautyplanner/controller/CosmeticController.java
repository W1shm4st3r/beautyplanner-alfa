package git.w1shm4st3r.beautyplanner.controller;

import git.w1shm4st3r.beautyplanner.dto.CosmeticDto;
import git.w1shm4st3r.beautyplanner.mapper.CosmeticMapper;
import git.w1shm4st3r.beautyplanner.model.Cosmetic;
import git.w1shm4st3r.beautyplanner.service.CosmeticService;
import git.w1shm4st3r.beautyplanner.service.impl.CosmeticServiceImpl;
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
public class CosmeticController {
    private final CosmeticService cosmeticService;

    public CosmeticController(CosmeticServiceImpl cosmeticService) {
        this.cosmeticService = cosmeticService;
    }

    @GetMapping("/cosmetics")
    public String getCosmeticList(Model model) {
        List<Cosmetic> cosmetics = cosmeticService.getAllCosmeticsSortedByDestination();
        model.addAttribute("cosmetics", cosmetics);
        return "cosmetic/cosmetics";
    }

    @GetMapping("/cosmetics/new")
    public String getAddingForm(Model model) {
        CosmeticDto cosmetic = new CosmeticDto();
        model.addAttribute("cosmetic", cosmetic);
        return "cosmetic/add-cosmetic";
    }

    @PostMapping("/cosmetics")
    public String addCosmetic(@Valid @ModelAttribute("cosmetic") CosmeticDto cosmetic,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cosmetic", cosmetic);
            return "/cosmetic/add-cosmetic";
        }
        cosmeticService.addCosmetic(cosmetic);
        return "redirect:/cosmetics";
    }

    @GetMapping("/cosmetics/{cosmeticId}/addToFavourites")
    public String addToFavourites(@PathVariable("cosmeticId") Long cosmeticId) {
        cosmeticService.addToFavourites(cosmeticId);
        return "redirect:/cosmetics";
    }

    @GetMapping("/cosmetics/{cosmeticId}/delete")
    public String deleteCosmetic(@PathVariable("cosmeticId") Long cosmeticId) {
        cosmeticService.deleteCosmetic(cosmeticId);
        return "redirect:/cosmetics";
    }

    @GetMapping("/cosmetics/{cosmeticId}/addToUsedUp")
    public String addToUsedUp(@PathVariable("cosmeticId") Long cosmeticId) {
        cosmeticService.addToUsedUp(cosmeticId);
        return "redirect:/cosmetics";
    }

    @GetMapping("/cosmetics/{cosmeticId}/edit")
    public String editCosmetic(@PathVariable("cosmeticId") Long cosmeticId, Model model) {
        Cosmetic cosmetic = cosmeticService.getCosmeticById(cosmeticId);
        model.addAttribute("cosmetic", cosmetic);
        return "cosmetic/edit-cosmetic";
    }

    @PostMapping("/cosmetics/{cosmeticId}/update")
    public String updateCosmetic(@PathVariable("cosmeticId") Long cosmeticId, @Valid @ModelAttribute CosmeticDto cosmetic,
                                 BindingResult result, Model model) {
        Cosmetic cosmeticToEdit = cosmeticService.getCosmeticById(cosmeticId);
        if (result.hasErrors()) {
            model.addAttribute("cosmetic", cosmetic);
            return "cosmetic/edit-cosmetic";
        }
        cosmetic.setId(cosmeticId);
        cosmetic.setIsFavourite(cosmeticToEdit.getIsFavourite());
        cosmetic.setIsUsedUp(cosmeticToEdit.getIsUsedUp());
        cosmeticService.updateCosmetic(cosmetic);
        return "redirect:/cosmetics";
    }

    @GetMapping("/cosmetics/{cosmeticId}/increaseApplications")
    public String increaseApplications(@PathVariable("cosmeticId") Long cosmeticId) {
        cosmeticService.increaseApplications(cosmeticId);
        return "redirect:/cosmetics";
    }

    @GetMapping("/cosmetics/{cosmeticId}/decreaseApplications")
    public String decreaseApplications(@PathVariable("cosmeticId") Long cosmeticId) {
        cosmeticService.decreaseApplications(cosmeticId);
        return "redirect:/cosmetics";
    }

    @GetMapping("/cosmetics/{cosmeticId}/cosmeticDetails")
    public String displayCosmeticDetails(@PathVariable("cosmeticId") Long cosmeticId, Model model) {
        CosmeticDto cosmetic = CosmeticMapper.mapToCosmeticDto(cosmeticService.getCosmeticById(cosmeticId));
        model.addAttribute("cosmetic", cosmetic);
        return "cosmetic/view-cosmetic";
    }

}
