package hu.ulyssys.java.course.food.delivery.dao.impl;

import hu.ulyssys.java.course.food.delivery.dao.OrderDAO;
import hu.ulyssys.java.course.food.delivery.entity.Order;

import javax.ejb.Stateless;

@Stateless
public class OrderDAOImpl extends CoreModifiableDAOImpl<Order> implements OrderDAO {
    @Override
    protected Class<Order> getManagedClass() {
        return Order.class;
    }
}
