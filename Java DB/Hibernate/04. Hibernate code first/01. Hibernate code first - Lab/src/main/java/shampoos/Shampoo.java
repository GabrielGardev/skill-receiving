package shampoos;

import ingredients.BasicIngredient;

import java.math.BigDecimal;
import java.util.Set;

public interface Shampoo {
    long getId();
    void setId(long id);
    String getBrand();
    void setBrand(String brand);
    BigDecimal getPrice();
    void setPrice(BigDecimal price);
    Size getSize();
    void setPrice(Size size);
    BasicLabel getLabel();
    void setLabel(BasicLabel label);
    Set<BasicIngredient> getIngredients();
    void setIngredients(Set<BasicIngredient> ingredients);

}
