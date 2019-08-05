package softuni.jsonexer.domain.dto;

import com.google.gson.annotations.Expose;

public class UserSoldProductDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Integer age;

    @Expose
    private ProductsSoldDto soldProducts;

    public UserSoldProductDto() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public ProductsSoldDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(ProductsSoldDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
