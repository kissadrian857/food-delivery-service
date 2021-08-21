package hu.ulyssys.java.course.food.delivery.dao.impl;

import hu.ulyssys.java.course.food.delivery.dao.CourierDAO;
import hu.ulyssys.java.course.food.delivery.entity.Courier;

import javax.ejb.Stateless;

@Stateless
public class CourierDAOImpl extends CoreModifiableDAOImpl<Courier> implements CourierDAO {
    @Override
    protected Class<Courier> getManagedClass() {
        return Courier.class;
    }
}