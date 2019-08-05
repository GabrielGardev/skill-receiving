package softuni.cardealer.domains.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "suppliers")
@Getter @Setter
public class Supplier extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(name = "is_importer", nullable = false)
    private boolean isImporter;

    @OneToMany(mappedBy = "supplier", targetEntity = Part.class)
    private Set<Part> parts;
}
