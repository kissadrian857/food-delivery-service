package hu.ulyssys.java.course.food.delivery.service;

import hu.ulyssys.java.course.food.delivery.entity.AbstractEntity;

import java.util.List;

public interface CoreService<T extends AbstractEntity> {
    List<T> getAll();

    T findById(Long id);

    void add(T entity);

    void remove(T entity);
}
