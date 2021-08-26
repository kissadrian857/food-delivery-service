package hu.ulyssys.java.course.delivery.mbean;

import hu.ulyssys.java.course.food.delivery.entity.Order;
import hu.ulyssys.java.course.food.delivery.service.OrderService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
@ViewScoped
public class OrderCRUDMbean extends CoreModifiableCRUDMbean<Order> {
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
}
