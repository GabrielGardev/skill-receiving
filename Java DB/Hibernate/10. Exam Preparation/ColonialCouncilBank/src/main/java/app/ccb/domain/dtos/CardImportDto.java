package app.ccb.domain.dtos;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "card")
@XmlAccessorType(XmlAccessType.FIELD)
public class CardImportDto {

    @XmlAttribute(name = "status")
    private String cardStatus;

    @XmlAttribute(name = "account-number")
    private String accountNumber;

    @XmlElement(name = "card-number")
    private String cardNumber;

    public CardImportDto() {
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @NotNull
    public String getCardStatus() {
        return cardStatus;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @NotNull
    public String getCardNumber() {
        return cardNumber;
    }
}
