package bg.softuni.sunpowa.repository;

import bg.softuni.sunpowa.model.dto.ProductDetailDTO;
import bg.softuni.sunpowa.model.entity.ProductEntity;
import bg.softuni.sunpowa.service.impl.ProductServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByUuid(UUID productUUID);
}
