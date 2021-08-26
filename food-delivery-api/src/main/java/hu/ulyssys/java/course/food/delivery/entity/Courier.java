package hu.ulyssys.java.course.food.delivery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Objects;

@NamedQuery(name = Courier.FIND_BY_FULLNAME, query = "select c from Courier c where c.fullName=:fullName")
@Entity
@Table(name = "courier")
public class Courier extends AbstractModifiableEntity {
    public static final String FIND_BY_FULLNAME = "Courier.findByFullName";
    @Column(name = "first_name", length = 500)
    private String firstName;
    //TODO különböző legyen a vezeték és keresztnév
    @Column(name = "last_name", length = 500)
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "full_name")
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Courier courier = (Courier) o;
        return Objects.equals(firstName, courier.firstName) && Objects.equals(lastName, courier.lastName) && Objects.equals(phoneNumber, courier.phoneNumber) && Objects.equals(fullName, courier.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, phoneNumber, fullName);
    }
}
