package hu.ulyssys.java.course.delivery.mbean;

import hu.ulyssys.java.course.food.delivery.entity.Courier;
import hu.ulyssys.java.course.food.delivery.entity.User;
import hu.ulyssys.java.course.food.delivery.service.CourierService;
import hu.ulyssys.java.course.food.delivery.service.UserService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
@ViewScoped
public class CourierCRUDMbean extends CoreModifiableCRUDMbean<Courier> {
    @Inject
    private UserService userService;
    @Inject
    private LoggedInUserBean userBean;

    @Inject
    public CourierCRUDMbean(CourierService service) {
        super(service);
    }

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }

    @Override
    public void save() {
        newEntity.setCreationDate(new Date(System.currentTimeMillis()));
        newEntity.setCreatorUser(getActualUser());
        newEntity.setFullName(newEntity.getFirstName() + " " + newEntity.getLastName());
        super.save();
    }

    @Override
    public void modify() {
        selectedModifiable.setModifierUser(getActualUser());
        super.modify();
    }

    public User getActualUser() {
        return userService.findByUsername(userBean.getModel().getUsername());
    }
}
