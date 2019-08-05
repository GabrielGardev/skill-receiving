package softuni.cardealer.domains.dtos.exportDtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class CarDto implements Serializable {
    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private Long travelledDistance;
}
