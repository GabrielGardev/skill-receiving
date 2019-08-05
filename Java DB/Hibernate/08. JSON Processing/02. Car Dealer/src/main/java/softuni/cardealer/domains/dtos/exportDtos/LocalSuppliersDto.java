package softuni.cardealer.domains.dtos.exportDtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class LocalSuppliersDto implements Serializable {

    @Expose
    private Integer Id;

    @Expose
    private String Name;

    @Expose
    private Integer partsCount;
}
