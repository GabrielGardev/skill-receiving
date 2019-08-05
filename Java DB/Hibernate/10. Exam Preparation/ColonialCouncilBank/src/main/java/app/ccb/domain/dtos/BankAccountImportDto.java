package app.ccb.domain.dtos;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "bank-account")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankAccountImportDto {

    @XmlAttribute(name = "client")
    private String clientName;

    @XmlElement(name = "account-number")
    private String accountNumber;

    @XmlElement(name = "balance")
    private BigDecimal balance;

    public BankAccountImportDto() {
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getClientName() {
        return clientName;
    }

    @NotNull
    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
