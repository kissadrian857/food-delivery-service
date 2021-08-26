package hu.ulyssys.java.course.food.delivery.service.impl;

import hu.ulyssys.java.course.food.delivery.dao.CourierDAO;
import hu.ulyssys.java.course.food.delivery.entity.Courier;
import hu.ulyssys.java.course.food.delivery.service.CourierService;

import javax.ejb.Stateless;

@Stateless
public class CourierServiceImpl extends AbstractModifiableServiceImpl<Courier> implements CourierService {
    @Override
    public Courier findByFullName(String fullName) {
        return ((CourierDAO) dao).findByFullName(fullName);
    }
}
