package softuni.cardealer.domains.dtos.exportDtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter @Setter
public class SaleDto implements Serializable {
    @Expose
    private CarDto car;

    @Expose
    private String customerName;

    @Expose
    private BigDecimal discount;

    @Expose
    private BigDecimal price;

    @Expose
    private BigDecimal priceWithDiscount;
}
