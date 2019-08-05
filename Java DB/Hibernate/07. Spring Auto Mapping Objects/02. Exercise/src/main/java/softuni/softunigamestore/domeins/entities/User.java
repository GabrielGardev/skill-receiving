package softuni.softunigamestore.domeins.entities;

import lombok.Getter;
import lombok.Setter;
import softuni.softunigamestore.domeins.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter @Setter
public class User extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^\\b[A-Za-z0-9+]+[a-zA-Z0-9]@[\\w]+\\.[A-Za-z]{2,4}\\b$",
    message = "Incorrect email.")
    private String email;

    @Column(nullable = false)
    @Pattern(regexp = "(?=^.{6,}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s)[0-9a-zA-Z!@#$%^&*()]*$",
    message = "Password doesn't mach the validations!")
    private String password;
    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_games",
            joinColumns = @JoinColumn(name = "users"),
            inverseJoinColumns = @JoinColumn(name = "games"))
    private Set<Game> games;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
