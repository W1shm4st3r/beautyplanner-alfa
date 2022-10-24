package git.w1shm4st3r.beautyplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/error")
    public String displayErrorPage() {
        return "error";
    }

}
