package softuni.cardealer.domains.dtos.exportDtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class CombineCarsPartsDto implements Serializable {

    @Expose
    private CarDto car;

    @Expose
    private PartDto[] parts;
}
