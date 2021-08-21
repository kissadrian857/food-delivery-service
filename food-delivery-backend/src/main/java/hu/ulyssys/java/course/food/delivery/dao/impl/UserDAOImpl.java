package hu.ulyssys.java.course.food.delivery.dao.impl;

import hu.ulyssys.java.course.food.delivery.dao.UserDAO;
import hu.ulyssys.java.course.food.delivery.entity.User;

import javax.ejb.Stateless;

@Stateless
public class UserDAOImpl extends CoreDAOImpl<User> implements UserDAO {
    @Override
    protected Class<User> getManagedClass() {
        return User.class;
    }
}