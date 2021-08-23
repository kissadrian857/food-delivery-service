package hu.ulyssys.java.course.delivery;

import hu.ulyssys.java.course.food.delivery.entity.Food;
import hu.ulyssys.java.course.food.delivery.service.FoodService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ViewScoped
public class FoodCRUDMbean extends CoreModifiableCRUDMbean<Food> {
    @Inject
    public FoodCRUDMbean(FoodService service) {
        super(service);
    }

//    @Override
//    protected Food initNewEntity() {
//        return new Food();
//    }

    public void addOrRemove(Food food) {
        if (selectedEntities.contains(food)) {
            selectedEntities.remove(food);
        } else {
            selectedEntities.add(food);
        }
    }
}
