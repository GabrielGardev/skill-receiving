package softuni.xmlexer.domain.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryWithProductsRootDto {

    @XmlElement(name = "product")
    private List<CategoryWithProductsDto> products;

    public List<CategoryWithProductsDto> getProducts() {
        return products;
    }

    public void setProducts(List<CategoryWithProductsDto> products) {
        this.products = products;
    }
}
