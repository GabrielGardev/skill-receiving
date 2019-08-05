package softuni.cardealer.domains.dtos.exportDtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
public class CustomerDto implements Serializable {
    @Expose
    private Integer id;

    @Expose
    private String name;

    @Expose
    private LocalDateTime birthDate;

    @Expose
    private boolean youngDriver;

    @Expose
    private SaleDto[] sales;
}
