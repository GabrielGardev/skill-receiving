package softuni.jsonexer.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.jsonexer.domain.dto.CategorySeedDto;
import softuni.jsonexer.domain.dto.CategoryWithProductsDto;
import softuni.jsonexer.domain.entity.Category;
import softuni.jsonexer.domain.entity.Product;
import softuni.jsonexer.repository.CategoryRepository;
import softuni.jsonexer.service.CategoryService;
import softuni.jsonexer.util.ValidatorUtil;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(ValidatorUtil validatorUtil, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories(CategorySeedDto[] categorySeedDtos) {
        for (CategorySeedDto categorySeedDto : categorySeedDtos) {
            if (!validatorUtil.isValid(categorySeedDto)){
                this.validatorUtil.violations(categorySeedDto)
                        .forEach(v -> System.out.println(v.getMessage()));

                continue;
            }

           Category category = this.modelMapper.map(categorySeedDto, Category.class);

            this.categoryRepository.saveAndFlush(category);
        }
    }

    @Override
    @Transactional
    public List<CategoryWithProductsDto> getCategoriesByProductsCount() {

        List<Category> categories = this.categoryRepository.getAllOrderedByCountOfProductsDesc();

        List<CategoryWithProductsDto> dtos = new ArrayList<>();

        for (Category category : categories) {

            List<Product> products = category.getProducts();
            CategoryWithProductsDto dto = this.modelMapper.map(category, CategoryWithProductsDto.class);
            dto.setProductsCount(products.size());

            BigDecimal totalRevenue = products.stream()
                    .map(Product::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            dto.setTotalRevenue(totalRevenue);
            dto.setAveragePrice(totalRevenue.divide(new BigDecimal(products.size()), MathContext.DECIMAL32));
            dto.setProductsCount(products.size());

            dtos.add(dto);
        }

        return dtos;
    }
}
