package hu.ulyssys.java.course.food.delivery.dao;

import hu.ulyssys.java.course.food.delivery.entity.AbstractModifiableEntity;

public interface CoreModifiableDAO<T extends AbstractModifiableEntity> extends CoreDAO<T> {
    T update(T entity);
}
