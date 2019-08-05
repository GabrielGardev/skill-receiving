package alararestaurant.service;

import alararestaurant.domain.entities.Category;
import alararestaurant.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public String exportCategoriesByCountOfItems() {
        StringBuilder sb = new StringBuilder();
        List<Category> categories = categoryRepository.findCategoriesByCountOfItems();
        String separator = System.lineSeparator();

        categories.forEach(c -> {
            sb.append("Category: ").append(c.getName()).append(separator);

            c.getItems().forEach(i -> sb.append("--- Item Name: ").append(i.getName()).append(separator)
                    .append("--- Item Price: ").append(String.format("%.2f", i.getPrice())).append(separator)
                    .append(separator));
        });
        return sb.toString().trim();
    }
}
