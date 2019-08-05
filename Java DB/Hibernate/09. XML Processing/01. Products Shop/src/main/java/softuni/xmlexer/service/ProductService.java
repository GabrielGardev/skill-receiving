package softuni.xmlexer.service;

import softuni.xmlexer.domain.dto.ProductInRangeRootDto;
import softuni.xmlexer.domain.dto.ProductRootDto;

import java.math.BigDecimal;

public interface ProductService {

    void seedProducts(ProductRootDto productRootDto);

    ProductInRangeRootDto productsInRange(BigDecimal more, BigDecimal less);
}
