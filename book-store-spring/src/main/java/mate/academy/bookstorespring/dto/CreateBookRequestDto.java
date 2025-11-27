package mate.academy.bookstorespring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateBookRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @NotBlank
    private String isbn;
    @Positive(message = "Price must be greater than 0")
    private BigDecimal price;
    private String description;
    private String coverImage;
}
