package git.w1shm4st3r.beautyplanner.controller;

import git.w1shm4st3r.beautyplanner.dto.CosmeticDto;
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
public class WishListController {

    private final CosmeticService cosmeticService;

    public WishListController(CosmeticService cosmeticService) {
        this.cosmeticService = cosmeticService;
    }

    @GetMapping("/wishList")
    public String getWishList(Model model) {
        List<Cosmetic> wishedCosmetics = cosmeticService.getWished();
        model.addAttribute("wishedCosmetics", wishedCosmetics);
        return "wished/wish-list";
    }

    @GetMapping("/wishList/new")
    public String getAddingWishedForm(Model model) {
        CosmeticDto wishedCosmetic = new CosmeticDto();
        model.addAttribute("wishedCosmetic", wishedCosmetic);
        return "wished/add-to-wishlist";
    }


    @PostMapping("/wishList")
    public String addToWishList(@Valid @ModelAttribute("cosmetic") CosmeticDto wishedCosmetic,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cosmetic", wishedCosmetic);
            return "wished/add-to-wishlist";
        }
        cosmeticService.addWishedCosmetic(wishedCosmetic);
        return "redirect:/wishList";
    }

    @GetMapping("/wishList/{cosmeticId}/moveToCollection")
    public String moveToCollection(@PathVariable("cosmeticId") Long cosmeticId) {
        cosmeticService.moveWishedToCollection(cosmeticId);
        return "redirect:/wishList";
    }

}
