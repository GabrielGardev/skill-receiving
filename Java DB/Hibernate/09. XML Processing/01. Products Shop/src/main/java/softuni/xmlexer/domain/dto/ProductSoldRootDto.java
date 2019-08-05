package softuni.xmlexer.domain.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSoldRootDto implements Serializable {

    @XmlElement(name = "product")
    private ProductSoldDto[] products;


    public ProductSoldDto[] getProducts() {
        return products;
    }

    public void setProducts(ProductSoldDto[] products) {
        this.products = products;
    }
}
