package app.ccb.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bank-accounts")
@XmlAccessorType(XmlAccessType.FIELD)
public class BankAccountRootImportDto {

    @XmlElement(name = "bank-account")
    private BankAccountImportDto[] bankAccountImportDtos;

    public BankAccountRootImportDto() {
    }

    public BankAccountImportDto[] getBankAccountImportDtos() {
        return bankAccountImportDtos;
    }

    public void setBankAccountImportDtos(BankAccountImportDto[] bankAccountImportDtos) {
        this.bankAccountImportDtos = bankAccountImportDtos;
    }
}
