package softuni.jsonexer.domain.dto;

import com.google.gson.annotations.Expose;

public class ProductsSoldDto {

    @Expose
    private Integer count;

    @Expose
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
