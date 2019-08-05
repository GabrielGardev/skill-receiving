package softuni.accountsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User extends BaseEntity {
    @Column(unique = true)
    private String username;
    @Column
    private int age;
    @OneToMany
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Set<Account> accounts;
}
