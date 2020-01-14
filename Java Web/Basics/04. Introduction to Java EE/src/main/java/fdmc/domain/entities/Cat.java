package fdmc.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Cat {
    private String name;
    private String breed;
    private String color;
    private int numberOfLegs;
}
