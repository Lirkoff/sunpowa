package bg.softuni.sunpowa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @GetMapping("/all")
    public String products() {
        return "products";
    }
}
