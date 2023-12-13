package bg.softuni.sunpowa.service;

import bg.softuni.sunpowa.model.dto.AddProductDTO;
import bg.softuni.sunpowa.model.dto.ProductDetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface ProductService {

    UUID addProduct(AddProductDTO addProductDTO);
    Optional<ProductDetailDTO> getProductDetail(UUID productUUID);

    Page<ProductDetailDTO> getAllProducts(Pageable pageable);
}
