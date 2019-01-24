package softuni.ebank.entities;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transaction")
public class Transaction {

    private Long id;
    private String type;
    private BankAccount from;
    private BankAccount to;
    private BigDecimal amount;

    public Transaction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "transaction_type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToOne(targetEntity = BankAccount.class)
    @JoinColumn(name = "sender", updatable = false)
    public BankAccount getFrom() {
        return from;
    }

    public void setFrom(BankAccount from) {
        this.from = from;
    }

    @ManyToOne(targetEntity = BankAccount.class)
    @JoinColumn(name = "receiver", updatable = false)
    public BankAccount getTo() {
        return to;
    }

    public void setTo(BankAccount to) {
        this.to = to;
    }

    @Column(name = "amount", nullable = false, updatable = false)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
