package hu.ulyssys.java.course.food.delivery.service;

import hu.ulyssys.java.course.food.delivery.entity.AbstractModifiableEntity;

public interface CoreModifiableService<T extends AbstractModifiableEntity> extends CoreService<AbstractModifiableEntity> {
    void update(T entity);
}
