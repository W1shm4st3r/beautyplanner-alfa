package git.w1shm4st3r.beautyplanner.controller;

import git.w1shm4st3r.beautyplanner.model.Cosmetic;
import git.w1shm4st3r.beautyplanner.service.CosmeticService;
import git.w1shm4st3r.beautyplanner.service.impl.CosmeticServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FavouritesController {

    private final CosmeticService cosmeticService;

    public FavouritesController(CosmeticServiceImpl cosmeticService) {
        this.cosmeticService = cosmeticService;
    }

    @GetMapping("/favourites")
    public String getFavourites(Model model) {
        List<Cosmetic> cosmetics = cosmeticService.getAllCosmetics();
        List<Cosmetic> favourites = new ArrayList<>();
        for (Cosmetic cosmetic : cosmetics) {
            if (cosmetic.getIsFavourite()) {
              favourites.add(cosmetic);
            }
        }
        model.addAttribute("favourites", favourites);
        return "favourites";
    }

    @GetMapping("/favourites/{cosmeticId}/removeFromFavourites")
    public String removeFromFavourites(@PathVariable("cosmeticId") Long cosmeticId) {
        cosmeticService.removeFromFavourites(cosmeticId);
        return "redirect:/favourites";
    }

}
