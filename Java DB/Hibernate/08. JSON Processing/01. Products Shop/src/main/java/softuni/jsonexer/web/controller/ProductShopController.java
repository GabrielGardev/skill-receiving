package softuni.jsonexer.web.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.jsonexer.domain.dto.*;
import softuni.jsonexer.service.CategoryService;
import softuni.jsonexer.service.ProductService;
import softuni.jsonexer.service.UserService;
import softuni.jsonexer.util.FileUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductShopController implements CommandLineRunner {

    private final static String USER_JSON_FILE_PATH =
            "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
                    "08. JSON Processing\\1. Products Shop\\src\\main\\resources\\json\\users.json";

    private final static String CATEGORY_JSON_FILE_PATH =
            "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
                    "08. JSON Processing\\1. Products Shop\\src\\main\\resources\\json\\categories.json";

    private final static String PRODUCT_JSON_FILE_PATH =
            "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
                    "08. JSON Processing\\1. Products Shop\\src\\main\\resources\\json\\products.json";

    private final Gson gson;
    private final FileUtil fileUtil;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public ProductShopController(Gson gson, FileUtil fileUtil, UserService userService, CategoryService categoryService, ProductService productService) {
        this.gson = gson;
        this.fileUtil = fileUtil;
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        //seedUsers();
        //seedCategories();
        //seedProducts();

        //productsInRange();

        //this.successfullySoldProducts();

        //this.categoriesByProductsCount();

        //this.usersAndProducts();
    }

    private void categoriesByProductsCount() {
        List<CategoryWithProductsDto> categoryWithProductsDtos = this.categoryService.getCategoriesByProductsCount();

        String categoryWithProductsJson = this.gson.toJson(categoryWithProductsDtos);

        System.out.println(categoryWithProductsJson);
    }

    private void usersAndProducts() {
        UsersAndProductsDto usersAndSoldProducts = this.userService.getUsersAndSoldProducts();

        String usersAndProductsJson = this.gson.toJson(usersAndSoldProducts);

        System.out.println(usersAndProductsJson);
    }

    private void successfullySoldProducts() {
        List<UserSoldProductWithBuyerDto> userSoldProductDtos = this.userService.getUsersWithAtLeastOneSuccessfullySoldProduct();

        String userSoldProductJson = this.gson.toJson(userSoldProductDtos);

        System.out.println(userSoldProductJson);
    }

    private void seedUsers() throws IOException {
        String content = this.fileUtil.fileContent(USER_JSON_FILE_PATH);

        UserSeedDto[] userSeedDtos = this.gson.fromJson(content, UserSeedDto[].class);

        this.userService.seedUsers(userSeedDtos);
    }

    private void seedCategories() throws IOException {
        String content = this.fileUtil.fileContent(CATEGORY_JSON_FILE_PATH);

        CategorySeedDto[] categorySeedDtos = this.gson.fromJson(content, CategorySeedDto[].class);

        this.categoryService.seedCategories(categorySeedDtos);
    }

    private void seedProducts() throws IOException {
        String content = this.fileUtil.fileContent(PRODUCT_JSON_FILE_PATH);

        ProductSeedDto[] productSeedDtos = this.gson.fromJson(content, ProductSeedDto[].class);

        this.productService.seedProducts(productSeedDtos);
    }

    private void productsInRange(){
        List<ProductInRangeDto> products = this.productService
                .productsInRange(BigDecimal.valueOf(500),BigDecimal.valueOf(1000));

        String productsInRangeJson = this.gson.toJson(products);

        System.out.println(productsInRangeJson);
    }
}
