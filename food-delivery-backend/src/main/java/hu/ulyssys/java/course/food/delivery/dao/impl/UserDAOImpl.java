package hu.ulyssys.java.course.food.delivery.dao.impl;

import hu.ulyssys.java.course.food.delivery.dao.UserDAO;
import hu.ulyssys.java.course.food.delivery.entity.User;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserDAOImpl extends CoreDAOImpl<User> implements UserDAO {
    @Override
    protected Class<User> getManagedClass() {
        return User.class;
    }

    @Override
    public User findByUsername(String username) {
        TypedQuery<User> query = entityManager.createNamedQuery(User.FIND_BY_USERNAME, User.class);
        query.setParameter("userName", username);
        List<User> userList = query.getResultList();
        if (userList.isEmpty()) {
            return null;
        }
        return userList.get(0);
    }
}
