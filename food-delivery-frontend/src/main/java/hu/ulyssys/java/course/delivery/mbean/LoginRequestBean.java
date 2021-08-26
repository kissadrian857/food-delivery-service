package hu.ulyssys.java.course.delivery.mbean;

import hu.ulyssys.java.course.delivery.mbean.model.LoggedInUserModel;
import hu.ulyssys.java.course.delivery.mbean.model.LoginModel;
import hu.ulyssys.java.course.food.delivery.entity.User;
import hu.ulyssys.java.course.food.delivery.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.PrimeFaces;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginRequestBean{
    private LoginModel model = new LoginModel();

    @Inject
    private LoggedInUserBean bean;

    @Inject
    private UserService userService;

    public void doLogin() {
        try {
            User user = userService.findByUsername(model.getUsername());
            if(user==null){
                throw new SecurityException("Nem létező felhasználó");
            }
            String hashedPassword = DigestUtils.sha512Hex(model.getPassword());
            if (!hashedPassword.equals(user.getPassword())) {
                throw new SecurityException("Nem megfelelő jelszó");
            }
            LoggedInUserModel loggedInUserModel = new LoggedInUserModel();
            loggedInUserModel.setUsername(user.getUserName());
            loggedInUserModel.setId(user.getId());
            loggedInUserModel.setRole(user.getRole());
            bean.setModel(loggedInUserModel);
            PrimeFaces.current().executeScript("PF('loginDialog').hide()");
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "sikertelen bejelentkezés", ""));
        }
    }

    public void doLogout() {
        bean.setModel(null);
    }

    public LoginModel getModel() {
        return model;
    }

    public void setModel(LoginModel model) {
        this.model = model;
    }
}
