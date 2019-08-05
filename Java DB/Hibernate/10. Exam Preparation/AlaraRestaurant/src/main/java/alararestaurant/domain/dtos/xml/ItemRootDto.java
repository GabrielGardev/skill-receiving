package alararestaurant.domain.dtos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemRootDto implements Serializable {

    @XmlElement(name = "item")
    private ItemXmlDto[] items;

    public ItemXmlDto[] getItems() {
        return items;
    }

    public void setItems(ItemXmlDto[] items) {
        this.items = items;
    }
}
