package chushka.web.servlets;

import chushka.domain.models.view.AllProductsViewModel;
import chushka.service.ProductService;
import chushka.util.HtmlReader;
import chushka.util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    private final static String INDEX_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java Web - January 2019\\Basics\\05. Java EE Servlet API\\src\\main\\resources\\views\\index.html";

    private final ProductService productService;
    private final HtmlReader htmlReader;
    private final ModelMapper modelMapper;

    @Inject
    public IndexServlet(ProductService productService, HtmlReader htmlReader, ModelMapper modelMapper) {
        this.productService = productService;
        this.htmlReader = htmlReader;
        this.modelMapper = modelMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String htmlFile = htmlReader.readHtmlFile(INDEX_PATH).
            replace("{{listItems}}", formatListItems());
        resp.getWriter().println(htmlFile);
    }

    private String formatListItems() {
        List<AllProductsViewModel> allProducts = productService
                .findAllProducts()
                .stream()
                .map(p -> modelMapper.map(p, AllProductsViewModel.class))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        allProducts.forEach(p -> {
            sb.append(String.format("<li><a href=\"/products/details?name=%s\">%s</li>",
                    p.getName(),
                    p.getName()));
        });

        return sb.toString().trim();
    }
}
