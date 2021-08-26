package hu.ulyssys.java.course.delivery.rest;

import hu.ulyssys.java.course.delivery.rest.model.FoodRestModel;
import hu.ulyssys.java.course.food.delivery.entity.Food;

import javax.ws.rs.Path;

@Path("/food")
public class FoodRestService extends CoreRestService<Food, FoodRestModel>{
    @Override
    protected Food initNewEntity() {
        return new Food();
    }
}
