package hu.ulyssys.java.course.delivery;


import hu.ulyssys.java.course.food.delivery.entity.User;
import hu.ulyssys.java.course.food.delivery.service.UserService;

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
}
