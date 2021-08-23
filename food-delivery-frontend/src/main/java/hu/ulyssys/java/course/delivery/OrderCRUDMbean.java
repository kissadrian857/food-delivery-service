package hu.ulyssys.java.course.delivery;

import hu.ulyssys.java.course.food.delivery.entity.Order;
import hu.ulyssys.java.course.food.delivery.service.OrderService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class OrderCRUDMbean extends CoreModifiableCRUDMbean<Order> {
    @Inject
    public OrderCRUDMbean(OrderService service) {
        super(service);
    }

//    @Override
//    protected Order initNewEntity() {
//        return new Order();
//    }
}
