package hu.ulyssys.java.course.food.delivery.service.impl;

import hu.ulyssys.java.course.food.delivery.dao.UserDAO;
import hu.ulyssys.java.course.food.delivery.entity.User;
import hu.ulyssys.java.course.food.delivery.service.UserService;

import javax.ejb.Stateless;

@Stateless
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {
    @Override
    public User findByUsername(String username) {
        return ((UserDAO) dao).findByUsername(username);
    }
}
