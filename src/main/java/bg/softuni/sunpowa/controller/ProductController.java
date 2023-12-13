package bg.softuni.sunpowa.controller;

import bg.softuni.sunpowa.model.dto.AddProductDTO;
import bg.softuni.sunpowa.model.dto.BrandDTO;
import bg.softuni.sunpowa.service.BrandService;
import bg.softuni.sunpowa.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final BrandService brandService;
    private final ProductService productService;

    public ProductController(BrandService brandService, ProductService productService) {
        this.brandService = brandService;
        this.productService = productService;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("addProductDTO")) {
            model.addAttribute("addProductDTO", new AddProductDTO(null,null,null,null));
        }

        model.addAttribute("brands", brandService.getAllBrands());

        return "product-add";
    }

    @PostMapping("/add")
    public String add(
            @Valid AddProductDTO addProductDTO,
            BindingResult bindingResult,
            RedirectAttributes rAtt) {

        if(bindingResult.hasErrors()){
            rAtt.addFlashAttribute("addProductDTO", addProductDTO);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.addProductDTO", bindingResult);
            return "redirect:/product/add";
        }



        UUID newProductUUID = productService.addProduct(addProductDTO);

        return "redirect:/product/add" + newProductUUID;
    }

    @GetMapping("/{uuid}")
    public String details(@PathVariable("uuid") UUID uuid, Model model){
        return "";
    }


}
