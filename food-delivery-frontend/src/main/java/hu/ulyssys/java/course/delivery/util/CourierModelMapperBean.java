package hu.ulyssys.java.course.delivery.util;

import hu.ulyssys.java.course.delivery.rest.model.CourierRestModel;
import hu.ulyssys.java.course.food.delivery.entity.Courier;

public class CourierModelMapperBean extends CoreModelMapperBean<CourierRestModel, Courier> {
    @Override
    public CourierRestModel initNewModel() {
        return new CourierRestModel();
    }

    @Override
    public CourierRestModel createModelFromEntity(Courier entity) {
        CourierRestModel courierModel = super.createModelFromEntity(entity);
        courierModel.setFirstName(entity.getFirstName());
        courierModel.setLastName(entity.getLastName());
        courierModel.setFullName(entity.getFullName());
        courierModel.setPhoneNumber(entity.getPhoneNumber());
        return courierModel;
    }

    @Override
    public void populateEntityFromModel(Courier entity, CourierRestModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setFullName(model.getFullName());
        entity.setPhoneNumber(model.getPhoneNumber());
    }
}
