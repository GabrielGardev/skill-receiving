package app.ccb.domain.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends BaseEntity {

    private String accountNumber;

    private BigDecimal balance;

    private Client client;

    private Set<Card> cards;

    public BankAccount() {
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    @Column(name = "account_number", nullable = false)
    public String getAccountNumber() {
        return accountNumber;
    }

    @Column(name = "balance")
    public BigDecimal getBalance() {
        return balance;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    public Client getClient() {
        return client;
    }

    @OneToMany(mappedBy = "bankAccount", targetEntity = Card.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Card> getCards() {
        return cards;
    }


}
