package bg.softuni.sunpowa.service.impl;

import bg.softuni.sunpowa.model.dto.AddProductDTO;
import bg.softuni.sunpowa.model.entity.BrandEntity;
import bg.softuni.sunpowa.model.entity.ProductEntity;
import bg.softuni.sunpowa.repository.BrandRepository;
import bg.softuni.sunpowa.repository.ProductRepository;
import bg.softuni.sunpowa.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    public ProductServiceImpl(ProductRepository productRepository, BrandRepository modelRepository) {
        this.productRepository = productRepository;
        this.brandRepository = modelRepository;
    }

    @Override
    public UUID addProduct(AddProductDTO addProductDTO) {
        ProductEntity product = map(addProductDTO);
        BrandEntity brand = brandRepository.findById(addProductDTO.brandId()).orElseThrow(()->
                new IllegalArgumentException("Brand with id " + addProductDTO.brandId() + " not found!"));
        product.setBrand(brand);

        product = productRepository.save(product);

        return product.getUuid();
    }

    private static ProductEntity map(AddProductDTO addProductDTO) {
        return new ProductEntity()
                .setUuid(UUID.randomUUID())
                .setDescription(addProductDTO.description())
                .setImageUrl(addProductDTO.imageUrl())
                .setPrice(BigDecimal.valueOf(addProductDTO.price()));
    }
}
