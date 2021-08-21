package hu.ulyssys.java.course.food.delivery.dao;

import hu.ulyssys.java.course.food.delivery.entity.AbstractModifiableEntity;

public interface CoreModifiableDAO<T extends AbstractModifiableEntity> extends CoreDAO<AbstractModifiableEntity> {
    T update(T entity);
}
