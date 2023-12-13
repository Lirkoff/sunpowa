package bg.softuni.sunpowa.service.impl;

import bg.softuni.sunpowa.model.dto.BrandDTO;
import bg.softuni.sunpowa.repository.BrandRepository;
import bg.softuni.sunpowa.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        return brandRepository.getAllBrands().stream()
                .map(brand -> new BrandDTO(
                        brand.getId(),
                        brand.getName(),
                        brand.getModel()
                )).sorted(Comparator.comparing(BrandDTO::name))
                .collect(Collectors.toList());

    }
}
