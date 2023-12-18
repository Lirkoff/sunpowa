package bg.softuni.sunpowa.controller;

import bg.softuni.sunpowa.model.dto.UserRegistrationDTO;
import bg.softuni.sunpowa.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }


    @PostMapping("/login-error")
    public String onFailure(Model model) {
        model.addAttribute("bad_credentials", true);

        return "auth-login";
    }


    @GetMapping("/register")
    public String register(Model model) {

        if (!model.containsAttribute("userRegistrationDTO")) {
            model.addAttribute("userRegistrationDTO", UserRegistrationDTO.empty());
        }

        return "auth-register";
    }


    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("userRegistrationDTO") UserRegistrationDTO userRegistrationDTO, BindingResult bindingResult,
                           RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()){
            rAtt.addFlashAttribute("userRegistrationDTO",userRegistrationDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO", bindingResult);
            return "redirect:/users/register";
        }

        userService.registerUser(userRegistrationDTO);


        return "redirect:/";
    }


    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}

