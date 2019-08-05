package softuni.jsonexer.service;

import softuni.jsonexer.domain.dto.CategorySeedDto;
import softuni.jsonexer.domain.dto.CategoryWithProductsDto;

import java.util.List;

public interface CategoryService {

    void seedCategories(CategorySeedDto[] categorySeedDtos);

    List<CategoryWithProductsDto> getCategoriesByProductsCount();
}
