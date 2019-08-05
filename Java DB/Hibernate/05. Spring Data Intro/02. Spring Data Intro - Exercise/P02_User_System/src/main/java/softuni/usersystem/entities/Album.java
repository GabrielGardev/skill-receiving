package softuni.usersystem.entities;

import lombok.Getter;
import lombok.Setter;
import softuni.usersystem.entities.constrains.Picture;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "albums")
@Getter @Setter
public class Album extends BaseEntity {

    private String name;

    @Column(name = "background_color")
    private String backgroundColor;

    @Column(name = "is_public")
    private boolean isPublic;

    @JoinTable(name = "albums_pictures", joinColumns = {
            @JoinColumn(name = "album_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "picture_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Set<Picture> pictures;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private User owner;
}
