package hu.ulyssys.java.course.food.delivery.dao.impl;

import hu.ulyssys.java.course.food.delivery.dao.CoreModifiableDAO;
import hu.ulyssys.java.course.food.delivery.entity.AbstractModifiableEntity;

public abstract class CoreModifiableDAOImpl<T extends AbstractModifiableEntity> extends CoreDAOImpl<T> implements CoreModifiableDAO<T> {
    @Override
    public T update(T entity) {
        return entityManager.merge(entity);
    }
}
