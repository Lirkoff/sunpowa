package bg.softuni.sunpowa.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity{
    @NotNull
    private UUID uuid;

    @NotEmpty
    @Column(columnDefinition = "TEXT")
    private String description;
    @NotNull
    @ManyToOne
    private BrandEntity brand;

    @NotEmpty
    private String imageUrl;

    @NotNull
    private BigDecimal price;

    public UUID getUuid() {
        return this.uuid;
    }

    public ProductEntity setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public ProductEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BrandEntity getBrand() {
        return this.brand;
    }

    public ProductEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public ProductEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public ProductEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
