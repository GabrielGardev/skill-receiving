package softuni.exam.domain.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "teams")
public class Team extends BaseEntity{

    @Column(nullable = false)
    @NotNull
    @Length(min = 3, max = 20)
    private String name;

    @NotNull
    @ManyToOne(targetEntity = Picture.class)
    @JoinColumn(name = "picture_id", referencedColumnName = "id", nullable = false)
    private Picture picture;

    public Team() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
