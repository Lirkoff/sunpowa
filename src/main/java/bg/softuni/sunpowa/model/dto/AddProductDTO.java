package bg.softuni.sunpowa.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AddProductDTO(@NotEmpty @Size(min = 5, max = 512) String description,
                            @Positive @NotNull Long brandId,
                            @NotEmpty String imageUrl,
                            @Positive @NotNull Integer price) {
}
