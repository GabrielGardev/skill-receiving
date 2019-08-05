package softuni.accountsystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Getter
@Setter @NoArgsConstructor @AllArgsConstructor
public class Account extends BaseEntity {
    @Column(columnDefinition = "DECIMAL UNSIGNED")
    private BigDecimal balance;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
