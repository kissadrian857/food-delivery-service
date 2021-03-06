package hu.ulyssys.java.course.food.delivery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class Food extends AbstractModifiableEntity {
    @Column(name = "name", length = 200)
    private String name;
    @Column(name = "description", length = 500)
    private String description;
    @Column(name = "price")
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
