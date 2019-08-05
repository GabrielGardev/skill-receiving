package softuni.cardealer.domains.dtos;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter @Setter
public class CustomerSeedDto {

    @Expose
    @NotNull(message = "Name cant be null!")
    private String name;

    @Expose
    @NotNull(message = "Birth date cant be null!")
    private LocalDateTime birthDate;

    @Expose
    @NotNull
    private boolean youngDriver;
}
