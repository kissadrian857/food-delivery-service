package hu.ulyssys.java.course.food.delivery.entity;

import java.util.Date;

public class AbstractEntity {
    private Long id;

    private Date creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
