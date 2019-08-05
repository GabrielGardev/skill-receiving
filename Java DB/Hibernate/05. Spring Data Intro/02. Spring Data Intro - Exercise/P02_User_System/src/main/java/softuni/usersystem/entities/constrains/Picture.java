package softuni.usersystem.entities.constrains;

import lombok.Getter;
import lombok.Setter;
import softuni.usersystem.entities.Album;
import softuni.usersystem.entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "pictures")
@Getter @Setter
public class Picture extends BaseEntity {

    private String title;
    private String caption;
    private String path;

    @ManyToMany(mappedBy = "pictures")
    private Set<Album> albums;
}
