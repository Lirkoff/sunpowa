package bg.softuni.sunpowa.service.impl;

import bg.softuni.sunpowa.model.dto.AddProductDTO;
import bg.softuni.sunpowa.model.dto.ProductDetailDTO;
import bg.softuni.sunpowa.model.entity.BrandEntity;
import bg.softuni.sunpowa.model.entity.ProductEntity;
import bg.softuni.sunpowa.repository.BrandRepository;
import bg.softuni.sunpowa.repository.ProductRepository;
import bg.softuni.sunpowa.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    public ProductServiceImpl(ProductRepository productRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
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

    @Override
    public Optional<ProductDetailDTO> getProductDetail(UUID productUUID) {
        return productRepository
                .findByUuid(productUUID)
                .map(this::mapAsDetails);
    }

    @Override
    public Page<ProductDetailDTO> getAllProducts(Pageable pageable) {
        return productRepository
                .findAll(pageable)
                .map(this::mapAsDetails);
    }

    private ProductDetailDTO mapAsDetails(ProductEntity productEntity) {
        return new ProductDetailDTO(
                productEntity.getUuid().toString(),
                productEntity.getDescription(),
                productEntity.getBrand().getName(),
                productEntity.getBrand().getModel(),
                productEntity.getImageUrl(),
                productEntity.getPrice()

        );
    }

    private static ProductEntity map(AddProductDTO addProductDTO) {
        return new ProductEntity()
                .setUuid(UUID.randomUUID())
                .setDescription(addProductDTO.description())
                .setImageUrl(addProductDTO.imageUrl())
                .setPrice(BigDecimal.valueOf(addProductDTO.price()));
    }

}
