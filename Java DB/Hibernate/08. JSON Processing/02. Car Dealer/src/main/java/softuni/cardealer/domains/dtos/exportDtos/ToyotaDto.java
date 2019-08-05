package softuni.cardealer.domains.dtos.exportDtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class ToyotaDto implements Serializable {

    @Expose
    private Integer Id;

    @Expose
    private String Make;

    @Expose
    private String Model;

    @Expose
    private Long TravelledDistance;
}
