package bg.softuni.sunpowa.service;

import bg.softuni.sunpowa.model.dto.BrandDTO;
import bg.softuni.sunpowa.model.entity.BrandEntity;

import java.util.List;

public interface BrandService {

    List<BrandDTO> getAllBrands();
}
