package softuni.cardealer.domains.dtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter @Setter
public class PartSeedDto {

    @Expose
    @NotNull(message = "Name cant be null!")
    private String name;

    @Expose
    @DecimalMin(value = "0.00000001", message = "Price cant be negative number!")
    @NotNull(message = "Price cant be null!")
    private BigDecimal price;

    @Expose
    @NotNull(message = "Quantity cant be null!")
    @Min(value = 1, message = "Cant have zero or less quantity!")
    private Integer quantity;
}
