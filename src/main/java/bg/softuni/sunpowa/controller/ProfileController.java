package bg.softuni.sunpowa.controller;


import bg.softuni.sunpowa.model.dto.UserChangeProfileDTO;
import bg.softuni.sunpowa.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/edit_profile")
    public String edit(Model model) {
        if (!model.containsAttribute("userChangeProfileDTO")) {
            model.addAttribute("userChangeProfileDTO", new UserChangeProfileDTO("",""));
        }

        return "profile";
    }

    @PostMapping("/edit_profile")
    public String edit(@Valid UserChangeProfileDTO userChangeProfileDTO, BindingResult bindingResult,
                       RedirectAttributes rAtt) {
        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("userChangeProfileDTO", userChangeProfileDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userChangeProfileDTO", bindingResult);
            return "redirect:/profile/edit_profile";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String oldEmail = auth.getName();


        userService.editProfile(oldEmail, userChangeProfileDTO.newEmail());


        return "redirect:/";
    }
}
