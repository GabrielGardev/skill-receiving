package softuni.softunigamestore.domeins.entities;

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "games")
@Getter @Setter
public class Game extends BaseEntity {

    @Column(nullable = false)
    @Pattern(regexp = "[A-Z]+[\\w ]*", message = "The name of the game is incorrect")
    @Size(min = 3, max = 100)
    private String title;

    @Column(length = 11, unique = true)
    @Size(min = 11, max = 11)
    private String trailer;

    @Pattern(regexp = "(http)s?://[\\w./-]*")
    private String thumbnail;

    @Column(nullable = false, scale = 2)
    @Positive(message = "Size must be positive")
    private double size;

    @Column(nullable = false, scale = 2)
    @Positive(message = "Price must be positive")
    private BigDecimal price;
    
    @Size(min = 20, max = 1000)
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToMany(mappedBy = "games")
    private Set<User> users;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.getTitle() != null ? this.getTitle().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!Game.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Game other = (Game) obj;
        return Objects.equals(this.title, other.title);
    }
}
