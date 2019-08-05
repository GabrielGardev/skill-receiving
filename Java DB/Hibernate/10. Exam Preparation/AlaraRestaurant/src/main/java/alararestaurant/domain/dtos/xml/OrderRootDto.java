package alararestaurant.domain.dtos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderRootDto implements Serializable {

    @XmlElement(name = "order")
    private OrderXmlDto[] orders;

    public OrderXmlDto[] getOrders() {
        return orders;
    }

    public void setOrders(OrderXmlDto[] orders) {
        this.orders = orders;
    }
}
