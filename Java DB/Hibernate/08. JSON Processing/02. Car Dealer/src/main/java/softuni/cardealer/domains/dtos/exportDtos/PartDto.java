package softuni.cardealer.domains.dtos.exportDtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter @Setter
public class PartDto implements Serializable {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;
}
