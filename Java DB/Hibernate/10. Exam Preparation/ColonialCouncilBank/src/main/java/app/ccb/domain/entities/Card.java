package app.ccb.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card extends BaseEntity {

    private String cardNumber;

    private String cardStatus;

    private BankAccount bankAccount;

    public Card() {
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Column(name = "card_number",nullable = false)
    public String getCardNumber() {
        return cardNumber;
    }

    @Column(name = "card_status",nullable = false)
    public String getCardStatus() {
        return cardStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_account_id",referencedColumnName = "id")
    public BankAccount getBankAccount() {
        return bankAccount;
    }

}
