package hu.ulyssys.java.course.food.delivery.dao.impl;

import hu.ulyssys.java.course.food.delivery.dao.FoodDAO;
import hu.ulyssys.java.course.food.delivery.entity.Food;

import javax.ejb.Stateless;

@Stateless
public class FoodDAOImpl extends CoreModifiableDAOImpl<Food> implements FoodDAO {
    @Override
    protected Class<Food> getManagedClass() {
        return Food.class;
    }
}
