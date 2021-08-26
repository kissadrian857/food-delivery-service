package hu.ulyssys.java.course.delivery.rest;

import hu.ulyssys.java.course.delivery.rest.model.OrderRestModel;
import hu.ulyssys.java.course.food.delivery.entity.Order;

import javax.ws.rs.Path;

@Path("/order")
public class OrderRestService extends CoreRestService<Order, OrderRestModel> {
    @Override
    protected Order initNewEntity() {
        return new Order();
    }
}
