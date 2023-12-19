package bg.softuni.sunpowa.controller;

import bg.softuni.sunpowa.model.dto.UserRoleManagementDTO;
import bg.softuni.sunpowa.model.entity.UserEntity;
import bg.softuni.sunpowa.model.entity.UserRolesEntity;
import bg.softuni.sunpowa.model.enums.UserRoleEnum;
import bg.softuni.sunpowa.repository.UserRepository;
import bg.softuni.sunpowa.repository.UserRolesRepository;
import bg.softuni.sunpowa.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/roles")
public class UserRoleController {
    private final UserRolesRepository userRolesRepository;
    private final UserRepository userRepository;

    private final UserService userService;

    public UserRoleController(UserRolesRepository userRolesRepository, UserRepository userRepository, UserService userService) {
        this.userRolesRepository = userRolesRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/management")
    public String manageRoles(Model model) {
        if (!model.containsAttribute("userRoleManagementDTO")) {
            model.addAttribute("userRoleManagementDTO", new UserRoleManagementDTO(""));
        }

        return "user-role-management";
    }

    @PostMapping("/management/addAdmin")
    public String addAdmin(@Valid UserRoleManagementDTO userRoleManagementDTO, BindingResult bindingResult,
                           RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("userRoleManagementDTO", userRoleManagementDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userRoleManagementDTO", bindingResult);
            return "redirect:/management/addAdmin";
        }

        userService.addUserRole(userRoleManagementDTO.username());


        return "redirect:/roles/management";
    }


    @PostMapping("/management/removeAdmin")
    public String removeAdmin(@Valid UserRoleManagementDTO userRoleManagementDTO, BindingResult bindingResult,
                           RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("userRoleManagementDTO", userRoleManagementDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userRoleManagementDTO", bindingResult);
            return "redirect:/management/addAdmin";
        }

        userService.removeUserRole(userRoleManagementDTO.username());

        return "redirect:/roles/management";
    }
}
