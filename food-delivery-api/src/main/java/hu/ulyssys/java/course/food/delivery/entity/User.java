package hu.ulyssys.java.course.food.delivery.entity;

import javax.persistence.*;

@NamedQuery(name = User.FIND_BY_USERNAME, query = "select u from User u where u.userName=:userName")
@Entity
@Table(name = "user_table")
public class User extends AbstractEntity {
    public static final String FIND_BY_USERNAME = "AppUser.findByUsername";
    @Column(name = "username", unique = true)
    private String userName;
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private AppUserRole role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUserRole getRole() {
        return role;
    }

    public void setRole(AppUserRole role) {
        this.role = role;
    }
}
