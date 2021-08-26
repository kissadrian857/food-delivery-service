package hu.ulyssys.java.course.food.delivery.dao.impl;

import hu.ulyssys.java.course.food.delivery.dao.CourierDAO;
import hu.ulyssys.java.course.food.delivery.entity.Courier;
import hu.ulyssys.java.course.food.delivery.entity.User;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CourierDAOImpl extends CoreModifiableDAOImpl<Courier> implements CourierDAO {
    @Override
    protected Class<Courier> getManagedClass() {
        return Courier.class;
    }

    @Override
    public Courier findByFullName(String fullName) {
        TypedQuery<Courier> query = entityManager.createNamedQuery(Courier.FIND_BY_FULLNAME, Courier.class);
        query.setParameter("fullName", fullName);
        List<Courier> courierList = query.getResultList();
        if (courierList.isEmpty()) {
            return null;
        }
        return courierList.get(0);
    }
}
