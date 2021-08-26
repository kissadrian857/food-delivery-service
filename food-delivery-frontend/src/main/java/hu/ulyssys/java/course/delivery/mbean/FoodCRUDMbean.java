package hu.ulyssys.java.course.delivery.mbean;

import hu.ulyssys.java.course.food.delivery.entity.Food;
import hu.ulyssys.java.course.food.delivery.entity.User;
import hu.ulyssys.java.course.food.delivery.service.FoodService;
import hu.ulyssys.java.course.food.delivery.service.UserService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
@ViewScoped
public class FoodCRUDMbean extends CoreModifiableCRUDMbean<Food> {
    @Inject
    private UserService userService;
    @Inject
    private LoggedInUserBean userBean;

    @Inject
    public FoodCRUDMbean(FoodService service) {
        super(service);
    }

    @Override
    protected Food initNewEntity() {
        return new Food();
    }

    @Override
    public void save() {
        newEntity.setCreationDate(new Date(System.currentTimeMillis()));
        newEntity.setCreatorUser(getActualUser());
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
