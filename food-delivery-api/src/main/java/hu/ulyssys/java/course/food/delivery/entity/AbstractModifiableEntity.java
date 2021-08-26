package hu.ulyssys.java.course.food.delivery.entity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractModifiableEntity extends AbstractEntity {
    @Column(name = "modified_date")
    private Date modifiedDate;

    @JoinColumn(name = "creator_id")
    @ManyToOne
    private User creatorUser;

    @JoinColumn(name = "modifier_id")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbstractModifiableEntity that = (AbstractModifiableEntity) o;
        return Objects.equals(modifiedDate, that.modifiedDate) && Objects.equals(creatorUser, that.creatorUser) && Objects.equals(modifierUser, that.modifierUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), modifiedDate, creatorUser, modifierUser);
    }
}
