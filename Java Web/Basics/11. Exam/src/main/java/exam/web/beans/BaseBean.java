package exam.web.beans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

public class BaseBean  {

    BaseBean() {
    }

    void redirect(String url)  {
        try {
            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .redirect("/view" + url + ".xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    }

    protected Map<String, String> getRequestParameterMap() {
        return FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();
    }
}
