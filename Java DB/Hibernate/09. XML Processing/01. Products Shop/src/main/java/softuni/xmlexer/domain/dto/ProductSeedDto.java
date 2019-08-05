package softuni.xmlexer.domain.dto;

import softuni.xmlexer.domain.entity.Category;
import softuni.xmlexer.domain.entity.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductSeedDto implements Serializable {

    @XmlElement
    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message = "Name should be at least 3 symbols")
    private String name;

    @XmlElement
    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price cannot be negative")
    private BigDecimal price;

    @XmlTransient
    @NotNull(message = "Seller cannot be null")
    private User seller;

    @XmlTransient
    private User buyer;

    @XmlTransient
    @NotNull(message = "Categories cannot be null")
    private List<Category> categories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
