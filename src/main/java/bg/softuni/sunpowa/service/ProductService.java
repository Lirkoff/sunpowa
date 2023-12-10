package bg.softuni.sunpowa.service;

import bg.softuni.sunpowa.model.dto.AddProductDTO;

import java.util.UUID;

public interface ProductService {

    UUID addProduct(AddProductDTO addProductDTO);
}
