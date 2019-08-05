package softuni.usersystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "countries")
@Getter @Setter
public class Country extends BaseEntity{

    private String name;

    @OneToMany(mappedBy = "country", targetEntity = Town.class)
    private Set<Town> towns;
}
