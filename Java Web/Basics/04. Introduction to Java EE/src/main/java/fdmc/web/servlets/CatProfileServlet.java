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

@WebServlet("/cats/profile")
public class CatProfileServlet extends HttpServlet {
    private final static String CAT_PROFILE_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java Web - January 2019\\Basics\\" +
            "04. Introduction to Java EE\\src\\main\\resources\\views\\cat-profile.html";

    private final static String CAT_NONEXISTENT_PATH = "C:\\Users\\Freeware Sys\\Projects\\Java Web - January 2019\\Basics\\" +
            "04. Introduction to Java EE\\src\\main\\resources\\views\\nonexistent-cat.html";

    private final HtmlReader htmlReader;

    @Inject
    public CatProfileServlet(HtmlReader htmlReader) {
        this.htmlReader = htmlReader;
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cat cat;
        try {
            cat = ((Map<String, Cat>) req.getSession().getAttribute("cats"))
                    .get(req.getQueryString().split("=")[1]);

           resp.getWriter().println(htmlReader.readHtmlFile(CAT_PROFILE_PATH)
                    .replace("{{name}}", cat.getName())
                    .replace("{{breed}}", cat.getBreed())
                    .replace("{{color}}", cat.getColor())
                    .replace("{{legs}}", String.valueOf(cat.getNumberOfLegs())));

        }catch (NullPointerException ex){
            resp.getWriter().println(htmlReader.readHtmlFile(CAT_NONEXISTENT_PATH)
            .replace("{{name}}", req.getQueryString().split("=")[1]));
        }
    }
}
