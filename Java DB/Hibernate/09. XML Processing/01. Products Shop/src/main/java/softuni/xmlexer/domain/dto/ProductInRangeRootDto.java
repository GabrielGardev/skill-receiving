package softuni.xmlexer.domain.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductInRangeRootDto implements Serializable {

    @XmlElement
    private List<ProductInRangeDto> product;

    public List<ProductInRangeDto> getProduct() {
        return product;
    }

    public void setProduct(List<ProductInRangeDto> product) {
        this.product = product;
    }
}
