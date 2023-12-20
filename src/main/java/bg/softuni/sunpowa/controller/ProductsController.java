package bg.softuni.sunpowa.controller;

import bg.softuni.sunpowa.model.dto.ProductDetailDTO;
import bg.softuni.sunpowa.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String all(Model model, @PageableDefault(size = 6, sort = "uuid") Pageable pageable) {
        Page<ProductDetailDTO> allProducts = productService.getAllProducts(pageable);

        model.addAttribute("products", allProducts);

        return "products";
    }


}
