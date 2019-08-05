package softuni.xmlexer.domain.dto;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "sold_products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsSoldDto {

    @XmlAttribute
    private Integer count;

    @XmlElement(name = "product")
    private ProductSoldWithOrWithoutBuyer[] products;

    public ProductsSoldDto() {
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setProducts(ProductSoldWithOrWithoutBuyer[] products) {
        this.products = products;
    }

    public Integer getCount() {
        return count;
    }

    public ProductSoldWithOrWithoutBuyer[] getProducts() {
        return products;
    }
}
