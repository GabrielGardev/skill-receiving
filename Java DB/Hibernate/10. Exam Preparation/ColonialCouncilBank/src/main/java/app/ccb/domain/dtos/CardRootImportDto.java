package app.ccb.domain.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cards")
@XmlAccessorType(XmlAccessType.FIELD)
public class CardRootImportDto {

    @XmlElement(name = "card")
    private CardImportDto[] cardImportDtos;

    public CardRootImportDto() {
    }

    public void setCardImportDtos(CardImportDto[] cardImportDtos) {
        this.cardImportDtos = cardImportDtos;
    }

    public CardImportDto[] getCardImportDtos() {
        return cardImportDtos;
    }
}
