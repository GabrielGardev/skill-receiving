package softuni.cardealer.domains.dtos.exportDtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter @Setter
public class CustomerWithCarDto implements Serializable {

    @Expose
    private String fullName;

    @Expose
    private Integer boughtCars;

    @Expose
    private BigDecimal spendMoney;
}
