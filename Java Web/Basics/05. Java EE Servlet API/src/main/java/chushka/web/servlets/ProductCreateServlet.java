package chushka.web.servlets;

import chushka.domain.enums.Type;
import chushka.domain.models.service.ProductServiceModel;
import chushka.service.ProductService;
import chushka.util.HtmlReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/products/create")
public class ProductCreateServlet extends HttpServlet {
    private final static String CREATE_PRODUCT_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java Web - January 2019\\Basics\\" +
            "05. Java EE Servlet API\\src\\main\\resources\\views\\create-product.html";

    private final ProductService productService;
    private final HtmlReader htmlReader;

    @Inject
    public ProductCreateServlet(ProductService productService, HtmlReader htmlReader) {
        this.productService = productService;
        this.htmlReader = htmlReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = htmlReader.readHtmlFile(CREATE_PRODUCT_PATH)
                .replace("{{typeOptions}}", formatTypeOptions());

        resp.getWriter().println(file);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       ProductServiceModel productServiceModel = new ProductServiceModel();
        productServiceModel.setName(req.getParameter("name"));
        productServiceModel.setDescription(req.getParameter("description"));
        productServiceModel.setType(req.getParameter("type"));

        productService.saveProduct(productServiceModel);

        resp.sendRedirect("/");
    }

    private String formatTypeOptions() {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(Type.values())
                .forEach(t -> sb.append(String.format("<option value=\"%s\">%s</option>", t.name(), t.name()))
                        .append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
