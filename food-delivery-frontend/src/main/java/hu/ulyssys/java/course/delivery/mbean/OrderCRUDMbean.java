package hu.ulyssys.java.course.delivery.mbean;

import hu.ulyssys.java.course.food.delivery.entity.Food;
import hu.ulyssys.java.course.food.delivery.entity.Order;
import hu.ulyssys.java.course.food.delivery.entity.User;
import hu.ulyssys.java.course.food.delivery.service.OrderService;
import hu.ulyssys.java.course.food.delivery.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

@Named
@ViewScoped
public class OrderCRUDMbean extends CoreModifiableCRUDMbean<Order> {
    @Inject
    private UserService userService;
    @Inject
    private LoggedInUserBean userBean;

    @Inject
    public OrderCRUDMbean(OrderService service) {
        super(service);
    }

    //Csak azért van ez a függvény hogy ne dobjon kivételt a datePicker
    @PostConstruct
    public void initDeliveryDate() {
        selectedModifiable = initNewEntity();
        selectedModifiable.setDeliveryDate(new Date());
    }

    @Override
    protected Order initNewEntity() {
        return new Order();
    }

    @Override
    public void modify() {
        selectedModifiable.setModifierUser(getActualUser());
        super.modify();
    }

    public User getActualUser() {
        return userService.findByUsername(userBean.getModel().getUsername());
    }

    public void saveOrder(List<Food> foods) {
        newEntity.setFoods(foods);
        newEntity.setCreationDate(new Date(System.currentTimeMillis()));
        newEntity.setCreatorUser(getActualUser());
        super.save();
    }

    public List<Food> getFoodListForOrder(Order order) {
        List<Food> foodList = order.getFoods();
        return foodList;
    }

    @Override
    public List<Order> getList() {
        if (userBean.getModel() == null) {
            return null;
        } else if (userBean.isAdmin()) {
            return super.getList();
        }
        List<Order> personalOrders = new ArrayList<>();
        for (Order o : list) {
            if (o.getCreatorUser().getUserName().equals(userBean.getModel().getUsername())) {
                personalOrders.add(o);
            }
        }
        return personalOrders;
    }
}
