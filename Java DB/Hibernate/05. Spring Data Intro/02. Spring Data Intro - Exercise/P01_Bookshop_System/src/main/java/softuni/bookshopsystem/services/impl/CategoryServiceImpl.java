package softuni.bookshopsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.bookshopsystem.entities.Category;
import softuni.bookshopsystem.repositories.CategoryRepository;
import softuni.bookshopsystem.services.CategoryService;
import softuni.bookshopsystem.utils.FileUtil;

import java.io.IOException;

@Service
public class CategoryServiceImpl implements CategoryService {
    //Dont forgot to change the @PATH when you test
    private static final String CATEGORIES_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "05. Spring Data Intro\\02. Spring Data Intro - Exercise\\P01_Bookshop_System\\src\\main\\resources\\files\\categories.txt";

    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }


    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0){
            return;
        }

        for (String[] names : fileUtil.fileContent(CATEGORIES_PATH)) {
            Category category = new Category();
            category.setName(names[0]);
            categoryRepository.saveAndFlush(category);
        }
    }
}
