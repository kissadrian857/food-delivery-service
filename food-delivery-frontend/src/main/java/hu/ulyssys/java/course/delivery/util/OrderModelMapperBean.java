package hu.ulyssys.java.course.delivery.util;

import hu.ulyssys.java.course.delivery.rest.model.FoodRestModel;
import hu.ulyssys.java.course.delivery.rest.model.OrderRestModel;
import hu.ulyssys.java.course.food.delivery.entity.Food;
import hu.ulyssys.java.course.food.delivery.entity.Order;
import hu.ulyssys.java.course.food.delivery.service.CourierService;

import javax.inject.Inject;
import java.util.ArrayList;

public class OrderModelMapperBean extends CoreModelMapperBean<OrderRestModel, Order> {
    @Inject
    FoodModelMapperBean foodModelMapperBean;

    @Inject
    CourierService courierService;

    @Override
    public OrderRestModel initNewModel() {
        return new OrderRestModel();
    }

    @Override
    public OrderRestModel createModelFromEntity(Order entity) {
        OrderRestModel orderModel = super.createModelFromEntity(entity);
        if(entity.getCourier()!=null){
            orderModel.setCourierId(entity.getCourier().getId());
        }
        orderModel.setDeliveryDate(entity.getDeliveryDate());
        orderModel.setSettlement(entity.getSettlement());
        orderModel.setPublicDomain(entity.getPublicDomain());
        orderModel.setTypeOfPublicArea(entity.getTypeOfPublicArea());
        orderModel.setHouseNumber(entity.getHouseNumber());
        orderModel.setFoods(new ArrayList<>());
        for (Food food : entity.getFoods()) {
            FoodRestModel foodModel = foodModelMapperBean.createModelFromEntity(food);
            orderModel.addFoodModel(foodModel);
        }

        return orderModel;
    }

    @Override
    public void populateEntityFromModel(Order entity, OrderRestModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setDeliveryDate(model.getDeliveryDate());
        if (model.getCourierId() != null) {
            entity.setCourier(courierService.findById(model.getCourierId()));
        } else {
            entity.setCourier(null);
        }
        entity.setSettlement(model.getSettlement());
        entity.setPublicDomain(model.getPublicDomain());
        entity.setTypeOfPublicArea(model.getTypeOfPublicArea());
        entity.setHouseNumber(model.getHouseNumber());
        entity.setFoods(new ArrayList<>());
        for (FoodRestModel foodModel : model.getFoods()) {
            Food food = new Food();
            foodModelMapperBean.populateEntityFromModel(food, foodModel);
            entity.getFoods().add(food);
        }
    }
}
