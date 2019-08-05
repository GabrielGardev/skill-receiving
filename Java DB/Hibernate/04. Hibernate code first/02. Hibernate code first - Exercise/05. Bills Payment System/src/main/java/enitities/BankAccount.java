package enitities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "bank_accounts")
public class BankAccount extends BillingDetail {
    private String bankName;
    private String swiftCode;

    public BankAccount() {
    }

    public BankAccount(String number, User owner, String bankName, String swiftCode) {
        super(number, owner);
        this.bankName = bankName;
        this.swiftCode = swiftCode;
    }

    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Column(name = "swift_code")
    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
