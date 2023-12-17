package bg.softuni.sunpowa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class UserRoleController {

    @GetMapping("/management")
    public String addRole() {
        return "user-role-management";
    }

}
