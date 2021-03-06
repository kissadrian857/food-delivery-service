package hu.ulyssys.java.course.food.delivery.dao;

import hu.ulyssys.java.course.food.delivery.entity.AbstractEntity;

import java.util.List;

public interface CoreDAO<T extends AbstractEntity> {
    List<T> findAll();

    T findById(Long id);

    T save(T entity);

    void delete(Long id);
}
