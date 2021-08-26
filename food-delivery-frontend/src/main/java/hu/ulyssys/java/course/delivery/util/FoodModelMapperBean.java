package hu.ulyssys.java.course.delivery.util;

import hu.ulyssys.java.course.delivery.rest.model.FoodRestModel;
import hu.ulyssys.java.course.food.delivery.entity.Food;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FoodModelMapperBean extends CoreModelMapperBean<FoodRestModel, Food> {
    @Override
    public FoodRestModel initNewModel() {
        return new FoodRestModel();
    }

    @Override
    public FoodRestModel createModelFromEntity(Food entity) {
        FoodRestModel foodModel = super.createModelFromEntity(entity);
        foodModel.setName(entity.getName());
        foodModel.setDescription(entity.getDescription());
        foodModel.setPrice(entity.getPrice());
        return foodModel;
    }

    @Override
    public void populateEntityFromModel(Food entity, FoodRestModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setPrice(model.getPrice());
    }
}
