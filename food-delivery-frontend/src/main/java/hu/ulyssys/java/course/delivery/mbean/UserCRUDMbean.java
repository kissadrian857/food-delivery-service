package hu.ulyssys.java.course.delivery.mbean;


import hu.ulyssys.java.course.food.delivery.entity.AppUserRole;
import hu.ulyssys.java.course.food.delivery.entity.User;
import hu.ulyssys.java.course.food.delivery.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class UserCRUDMbean extends CoreCRUDMbean<User> {
    @Inject
    public UserCRUDMbean(UserService service) {
        super(service);
    }

    @Override
    protected User initNewEntity() {
        return new User();
    }

    @Override
    public void save() {
        String hashedPassword = DigestUtils.sha512Hex(newEntity.getPassword());
        newEntity.setPassword(hashedPassword);
        super.save();
    }

    public AppUserRole[] getRoles() {
        AppUserRole[] roles = new AppUserRole[AppUserRole.values().length];
        int i = 0;
        for (AppUserRole r : AppUserRole.values()) {
            roles[i++] = r;
        }
        return roles;
    }
}
