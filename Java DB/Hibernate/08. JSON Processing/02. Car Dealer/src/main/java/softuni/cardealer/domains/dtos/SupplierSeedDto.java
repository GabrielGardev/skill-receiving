package softuni.cardealer.domains.dtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class SupplierSeedDto {

    @Expose
    @NotNull(message = "Name cant be null")
    private String name;

    @Expose
    @NotNull(message = "Is it importer cant be null")
    private boolean isImporter;
}
