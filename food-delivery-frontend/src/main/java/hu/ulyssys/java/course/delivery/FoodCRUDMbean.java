package hu.ulyssys.java.course.delivery;

import hu.ulyssys.java.course.food.delivery.entity.Food;
import hu.ulyssys.java.course.food.delivery.service.FoodService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class FoodCRUDMbean extends CoreCRUDMbean<Food> {
    @Inject
    public FoodCRUDMbean(FoodService service) {
        super(service);
    }

    @Override
    protected Food initNewEntity() {
        return new Food();
    }
}
