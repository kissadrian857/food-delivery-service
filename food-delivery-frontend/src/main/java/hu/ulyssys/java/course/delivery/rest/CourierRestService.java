package hu.ulyssys.java.course.delivery.rest;

import hu.ulyssys.java.course.delivery.rest.model.CourierRestModel;
import hu.ulyssys.java.course.food.delivery.entity.Courier;

import javax.ws.rs.Path;

@Path("/courier")
public class CourierRestService extends CoreRestService<Courier, CourierRestModel> {
    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }
}
