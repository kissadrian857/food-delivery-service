package hu.ulyssys.java.course.food.delivery.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractModifiableEntity extends AbstractEntity{
    @Column(name = "modified_date")
    private Date modifiedDate;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User creatorUser;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User modifierUser;

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public User getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(User creatorUser) {
        this.creatorUser = creatorUser;
    }

    public User getModifierUser() {
        return modifierUser;
    }

    public void setModifierUser(User modifierUser) {
        this.modifierUser = modifierUser;
    }
}
