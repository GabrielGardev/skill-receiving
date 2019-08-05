package softuni.cardealer.domains.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "customers")
@Getter @Setter
public class Customer extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(name = "birth_date", nullable = false)
    private LocalDateTime birthDate;

    @Column(name = "is_young_driver", nullable = false)
    private boolean youngDriver;

    @OneToMany(mappedBy = "customer", targetEntity = Sale.class)
    private Set<Sale> sales;
}
