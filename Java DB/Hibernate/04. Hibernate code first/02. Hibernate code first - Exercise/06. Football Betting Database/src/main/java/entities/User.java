package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "users")
public class User extends BaseEntityWithName {
    private String password;
    private String email;
    private String fullName;
    private BigDecimal balance;


    public User() {
    }

    public User(String userName, String password, String email, String fullName, BigDecimal balance) {
        super(userName);
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.balance = balance;
    }

    @Override
    @Column(name = "username")
    public String getName() {
        return super.getName();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

