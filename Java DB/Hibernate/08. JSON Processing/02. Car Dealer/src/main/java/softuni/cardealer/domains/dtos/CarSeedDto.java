package softuni.cardealer.domains.dtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class CarSeedDto {

    @Expose
    @NotNull(message = "Make cant be null!")
    private String make;

    @Expose
    @NotNull(message = "Model cant be null!")
    private String model;

    @Expose
    @NotNull(message = "Travelled_distance cant be null!")
    private Long travelledDistance;
}
