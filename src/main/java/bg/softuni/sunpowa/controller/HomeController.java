package bg.softuni.sunpowa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/products")
    public String products() {
        return "products";
    }

    @GetMapping("/products_registration")
    public String productsRegistration() {
        return "products-reg";
    }

    @GetMapping("/support")
    public String support() {
        return "support";
    }

    @GetMapping("/add_product")
    public String addProduct() {
        return "add-product";
    }


}
