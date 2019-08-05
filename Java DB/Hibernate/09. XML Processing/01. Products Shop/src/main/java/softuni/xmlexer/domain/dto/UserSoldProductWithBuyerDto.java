package softuni.xmlexer.domain.dto;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserSoldProductWithBuyerDto {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlElement(name = "sold-products")
    private ProductSoldRootDto soldProducts;

    public UserSoldProductWithBuyerDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public ProductSoldRootDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductSoldRootDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
