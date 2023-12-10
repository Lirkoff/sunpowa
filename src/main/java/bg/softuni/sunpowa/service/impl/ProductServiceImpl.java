package bg.softuni.sunpowa.service.impl;

import bg.softuni.sunpowa.model.dto.AddProductDTO;
import bg.softuni.sunpowa.repository.ModelRepository;
import bg.softuni.sunpowa.repository.ProductRepository;
import bg.softuni.sunpowa.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository offerRepository;
    private final ModelRepository modelRepository;

    public ProductServiceImpl(ProductRepository offerRepository, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public UUID addProduct(AddProductDTO addProductDTO) {
        return null;
    }
}
