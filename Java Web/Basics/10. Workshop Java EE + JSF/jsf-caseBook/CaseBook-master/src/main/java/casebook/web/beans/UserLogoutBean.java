package casebook.web.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named
@RequestScoped
public class UserLogoutBean {

    public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        FacesContext.getCurrentInstance().getExternalContext().redirect("/");
    }
}
