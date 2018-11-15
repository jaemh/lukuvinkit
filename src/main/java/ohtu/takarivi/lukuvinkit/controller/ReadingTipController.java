package ohtu.takarivi.lukuvinkit.controller;

import ohtu.takarivi.lukuvinkit.domain.CustomUser;
import ohtu.takarivi.lukuvinkit.domain.ReadingTip;
import ohtu.takarivi.lukuvinkit.repository.CustomUserRepository;
import ohtu.takarivi.lukuvinkit.repository.ReadingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The Spring controller for reading tip related activity.
 */
@Controller
public class ReadingTipController {

    @Autowired
    private CustomUserRepository customUserRepository;

    @Autowired
    private ReadingTipRepository readingTipRepository;

    @PostMapping(value = "/addReadingTip")
    public String submitReadTip(Authentication auth, @RequestParam String title, @RequestParam String description,
                                @RequestParam String url) {
        CustomUser customUser = customUserRepository.findByUsername(auth.getName());
        if (!title.trim().isEmpty() && !description.trim().isEmpty() && !url.trim().isEmpty()) {
            readingTipRepository.save(new ReadingTip(title, description, url, customUser));
        }
        return "redirect:/";
    }

}
