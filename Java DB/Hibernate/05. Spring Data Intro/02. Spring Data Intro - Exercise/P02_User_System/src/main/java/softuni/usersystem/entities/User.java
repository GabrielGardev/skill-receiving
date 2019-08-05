package softuni.usersystem.entities;

import lombok.Getter;
import lombok.Setter;
import softuni.usersystem.entities.constrains.Password;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter @Setter
public class User extends BaseEntity{

    @Min(value = 4)
    @Column(name = "username", nullable = false, length = 30)
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Password
    @Column(nullable = false)
    private String password;

    @Email(regexp = "^\\b[A-Za-z0-9+_.-]+[a-zA-Z0-9_]@[\\w]+\\.[A-Za-z]{2,4}\\b$")
    @Column(nullable = false)
    private String email;

    @Column(name = "registered_on")
    private LocalDate registeredOn;

    @Column(name = "last_time_logged_in")
    private LocalDate lastLogin;

    @Min(value = 1)
    @Max(value = 120)
    private int age;

    @Column(name = "is_deleted")
    private boolean isDeleted;


    @ManyToOne
    @JoinColumn(name = "born_town_id", referencedColumnName = "id")
    private Town bornTown;

    @ManyToOne
    @JoinColumn(name = "currently_living_town_id", referencedColumnName = "id")
    private Town currentlyLivingTown;

    @Transient
    private String fullName;

    @JoinTable(name = "friendship", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "friend_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Set<User> friends;

    @OneToMany(mappedBy = "owner", targetEntity = Album.class)
    private Set<Album> albums;

    public User() {
        this.setFullName(firstName + " " + lastName);
    }
}
