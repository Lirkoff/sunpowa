package bg.softuni.sunpowa.controller;

import bg.softuni.sunpowa.model.dto.UserRegistrationDTO;
import bg.softuni.sunpowa.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String onFailure(@ModelAttribute("email") String email, Model model) {
        model.addAttribute("email", email);
        model.addAttribute("bad_credentials", true);

        return "auth-login";
    }


    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }


    @PostMapping("/register")
    public String register(UserRegistrationDTO userRegistrationDTO) {
        userService.registerUser(userRegistrationDTO);


        return "redirect:/";
    }


    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
