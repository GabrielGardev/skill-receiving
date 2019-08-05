package softuni.xmlexer.service;

import softuni.xmlexer.domain.dto.CategoryRootDto;
import softuni.xmlexer.domain.dto.CategoryWithProductsRootDto;

public interface CategoryService {

    void seedCategories(CategoryRootDto categoryRootDto);

    CategoryWithProductsRootDto getCategoriesByProductsCount();
}
