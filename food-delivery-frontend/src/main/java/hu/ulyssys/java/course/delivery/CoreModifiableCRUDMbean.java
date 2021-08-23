package hu.ulyssys.java.course.delivery;

import hu.ulyssys.java.course.food.delivery.entity.AbstractModifiableEntity;
import hu.ulyssys.java.course.food.delivery.service.CoreService;

public abstract class CoreModifiableCRUDMbean<T extends AbstractModifiableEntity> extends CoreCRUDMbean<T> {
    public CoreModifiableCRUDMbean(CoreService<T> service) {
        super(service);
    }

    public void modify(org.apache.poi.ss.formula.functions.T entity) {
        //TODO implement
    }
}
