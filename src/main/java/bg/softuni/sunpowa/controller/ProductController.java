package bg.softuni.sunpowa.controller;

import bg.softuni.sunpowa.model.dto.AddProductDTO;
import bg.softuni.sunpowa.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final BrandService brandService;

    public ProductController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("addProductDTO")) {
            model.addAttribute("addProductDTO", new AddProductDTO(null,null,null,null));
        }

        model.addAttribute("brands", brandService.getAllBrands());

        return "product-add";
    }
}
