package softuni.jsonexer.domain.dto;

import com.google.gson.annotations.Expose;

public class UserSoldProductWithBuyerDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private ProductSoldDto[] soldProducts;

    public ProductSoldDto[] getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductSoldDto[] soldProducts) {
        this.soldProducts = soldProducts;
    }

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


}
