package softuni.xmlexer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import softuni.xmlexer.domain.dto.*;
import softuni.xmlexer.service.CategoryService;
import softuni.xmlexer.service.ProductService;
import softuni.xmlexer.service.UserService;
import softuni.xmlexer.util.XmlParser;
import softuni.xmlexer.util.XmlParserImpl;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class ProductShopController implements CommandLineRunner {

    private final static String USER_FILE_PATH =
            "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
                    "09. XML Processing\\01. Products Shop\\src\\main\\resources\\xml\\users.xml";

    private final static String CATEGORY_FILE_PATH =
            "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
                    "09. XML Processing\\01. Products Shop\\src\\main\\resources\\xml\\categories.xml";

    private final static String PRODUCT_FILE_PATH =
            "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
                    "09. XML Processing\\01. Products Shop\\src\\main\\resources\\xml\\products.xml";

    private final static String PRODUCT_IN_RANGE_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "09. XML Processing\\01. Products Shop\\src\\main\\resources\\xml\\export\\products_in_range.xml";

    private final static String USERS_SOLD_PRODUCTS = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "09. XML Processing\\01. Products Shop\\src\\main\\resources\\xml\\export\\users-sold-products.xml";

    private final static String CATEGORIES_BY_PRODUCTS = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "09. XML Processing\\01. Products Shop\\src\\main\\resources\\xml\\export\\categories-by-products.xml";

    private final static String USERS_AND_PRODUCTS = "C:\\Users\\Freeware Sys\\Projects\\Java DB\\Hibernate\\" +
            "09. XML Processing\\01. Products Shop\\src\\main\\resources\\xml\\export\\users-and-products.xml";

    private final XmlParserImpl xmlParser;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public ProductShopController(XmlParserImpl xmlParser, UserService userService, CategoryService categoryService, ProductService productService) {
        this.xmlParser = xmlParser;
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        //this.seedUsers();
        //this.seedCategories();
        //this.seedProducts();

        //this.productsInRange();

        //this.successfullySoldProducts();

        //this.categoriesByProductsCount();

        //this.usersAndProducts();
    }

    private void categoriesByProductsCount() throws JAXBException {
        CategoryWithProductsRootDto categories = this.categoryService.getCategoriesByProductsCount();
        this.xmlParser.exportToXml(categories, CATEGORIES_BY_PRODUCTS);
    }

    private void usersAndProducts() throws JAXBException {
        UsersAndProductsRootDto usersAndSoldProducts = this.userService.getUsersAndSoldProducts();
        this.xmlParser.exportToXml(usersAndSoldProducts, USERS_AND_PRODUCTS);
    }

    private void successfullySoldProducts() throws JAXBException, FileNotFoundException {
        UserSoldProductsWithBuyerRootDto dto
                = this.userService.getUsersWithAtLeastOneSuccessfullySoldProduct();
        this.xmlParser.exportToXml(dto, USERS_SOLD_PRODUCTS);
    }

    private void seedUsers() throws IOException, JAXBException {
        UserRootDto userRootDto = this.xmlParser.parseXml(UserRootDto.class, USER_FILE_PATH);
        this.userService.seedUsers(userRootDto);
    }

    private void seedCategories() throws IOException, JAXBException {
        CategoryRootDto rootDto = this.xmlParser.parseXml(CategoryRootDto.class, CATEGORY_FILE_PATH);
        this.categoryService.seedCategories(rootDto);
    }

    private void seedProducts() throws IOException, JAXBException {
        ProductRootDto dto = this.xmlParser.parseXml(ProductRootDto.class, PRODUCT_FILE_PATH);
        this.productService.seedProducts(dto);
    }

    private void productsInRange() throws JAXBException {
        ProductInRangeRootDto products = this.productService
                .productsInRange(BigDecimal.valueOf(500),BigDecimal.valueOf(1000));
        this.xmlParser.exportToXml(products, PRODUCT_IN_RANGE_PATH);
    }
}
