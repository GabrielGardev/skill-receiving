package fdmc.web.servlets;

import fdmc.domain.entities.Cat;
import fdmc.util.HtmlReader;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/cats/all")
public class CatAllServlet extends HttpServlet {
    private final static String ALL_CATS = "C:\\Users\\Freeware Sys\\Projects\\Java Web - January 2019\\Basics\\" +
            "04. Introduction to Java EE\\src\\main\\resources\\views\\all-cats.html";

    private final HtmlReader htmlReader;

    @Inject
    public CatAllServlet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String file = htmlReader.readHtmlFile(ALL_CATS);

        try {
            StringBuilder sb = new StringBuilder();
            ((Map<String, Cat>) req.getSession().getAttribute("cats"))
                    .values().forEach(c -> {
                        sb.append(String.format("<h3><a href=\"/cats/profile?catName=%s\">%s</a><br/></h3>",
                                c.getName(), c.getName()));
                    });

            file = file.replace("{{allCats}}", sb.toString().trim());

        }catch (NullPointerException ex){
            file = file.replace("{{allCats}}",
                    "There are no cats.<a href=\"/cats/create\">Create Some!</a>");
        }

        resp.getWriter().println(file);
    }
}
