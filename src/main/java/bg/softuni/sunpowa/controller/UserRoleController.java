package bg.softuni.sunpowa.controller;

import bg.softuni.sunpowa.model.dto.UserRoleManagementDTO;
import bg.softuni.sunpowa.model.entity.UserEntity;
import bg.softuni.sunpowa.model.entity.UserRolesEntity;
import bg.softuni.sunpowa.model.enums.UserRoleEnum;
import bg.softuni.sunpowa.repository.UserRepository;
import bg.softuni.sunpowa.repository.UserRolesRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/roles")
public class UserRoleController {
    private final UserRolesRepository userRolesRepository;
    private final UserRepository userRepository;

    public UserRoleController(UserRolesRepository userRolesRepository, UserRepository userRepository) {
        this.userRolesRepository = userRolesRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/management")
    public String manageRoles(Model model) {
        if (!model.containsAttribute("userRoleManagementDTO")) {
            model.addAttribute("userRoleManagementDTO", new UserRoleManagementDTO(""));
        }

        return "user-role-management";
    }

    @PostMapping("/management/addAdmin")
    public String addAdmin(UserRoleManagementDTO userRoleManagementDTO, BindingResult bindingResult,
                           RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("userRoleManagementDTO", userRoleManagementDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userRoleManagementDTO", bindingResult);
            return "redirect:/management/addAdmin";
        }

        UserEntity user = userRepository.findByEmail(userRoleManagementDTO.username()).get();
        UserRolesEntity role = userRolesRepository.getByRole(UserRoleEnum.ADMIN);

        user.getRoles().add(role);




        System.out.println("Successfully added admin " + user.getEmail());

        user.getRoles().forEach(r-> System.out.println(r.getRole().name()));

        return "redirect:/roles/management";
    }


    @PostMapping("/management/removeAdmin")
    public String removeAdmin(UserRoleManagementDTO userRoleManagementDTO, BindingResult bindingResult,
                           RedirectAttributes rAtt) {

        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("userRoleManagementDTO", userRoleManagementDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.userRoleManagementDTO", bindingResult);
            return "redirect:/management/addAdmin";
        }

        UserEntity user = userRepository.findByEmail(userRoleManagementDTO.username()).get();
        UserRolesEntity role = userRolesRepository.getByRole(UserRoleEnum.ADMIN);

        user.getRoles().remove(role);




        System.out.println("Successfully removed admin " + user.getEmail());

        user.getRoles().forEach(r-> System.out.println(r.getRole().name()));

        return "redirect:/roles/management";
    }
}
