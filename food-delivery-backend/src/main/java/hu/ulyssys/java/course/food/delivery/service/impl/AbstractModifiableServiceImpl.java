package hu.ulyssys.java.course.food.delivery.service.impl;

import hu.ulyssys.java.course.food.delivery.dao.CoreModifiableDAO;
import hu.ulyssys.java.course.food.delivery.entity.AbstractModifiableEntity;
import hu.ulyssys.java.course.food.delivery.service.CoreModifiableService;

import javax.inject.Inject;

public abstract class AbstractModifiableServiceImpl<T extends AbstractModifiableEntity> extends AbstractServiceImpl<T> implements CoreModifiableService<T> {
    @Inject
    private CoreModifiableDAO<T> dao;

    @Override
    public void update(T entity) {
        dao.update(entity);
    }
}
