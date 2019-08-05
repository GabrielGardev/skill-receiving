package softuni.xmlexer.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.xmlexer.domain.dto.CategoryRootDto;
import softuni.xmlexer.domain.dto.CategorySeedDto;
import softuni.xmlexer.domain.dto.CategoryWithProductsDto;
import softuni.xmlexer.domain.dto.CategoryWithProductsRootDto;
import softuni.xmlexer.domain.entity.Category;
import softuni.xmlexer.domain.entity.Product;
import softuni.xmlexer.repository.CategoryRepository;
import softuni.xmlexer.service.CategoryService;
import softuni.xmlexer.util.ValidatorUtil;

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
    public void seedCategories(CategoryRootDto categoryRootDto) {
        for (CategorySeedDto categorySeedDto : categoryRootDto.getCategories()) {
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
    public CategoryWithProductsRootDto getCategoriesByProductsCount() {

        List<Category> categories = this.categoryRepository.getAllOrderedByCountOfProductsDesc();

        List<CategoryWithProductsDto> dtos = new ArrayList<>();

        for (Category category : categories) {

            List<Product> products = category.getProducts();
            CategoryWithProductsDto dto = this.modelMapper.map(category, CategoryWithProductsDto.class);

            BigDecimal totalRevenue = products.stream()
                    .map(Product::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            dto.setTotalRevenue(totalRevenue);
            dto.setAveragePrice(totalRevenue.divide(new BigDecimal(products.size()), MathContext.DECIMAL32));
            dto.setProductsCount(products.size());

            dtos.add(dto);
        }
        CategoryWithProductsRootDto category = new CategoryWithProductsRootDto();
        category.setProducts(dtos);

        return category;
    }
}
