package softuni.cardealer.domains.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "parts")
@Getter @Setter
public class Part extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToMany(mappedBy = "parts", targetEntity = Car.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Car> cars;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;
}
