package hu.ulyssys.java.course.food.delivery.entity;


import hu.ulyssys.java.course.food.delivery.converter.FoodListConverter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_table")
public class Order extends AbstractModifiableEntity {
    @Column(name = "delivery_date")
    private Date deliveryDate;
    @JoinColumn(name = "courier_id")
    @ManyToOne
    private Courier courier;
    //TODO minimum egy eleme legyen
    @Column(name = "foods")
    @Convert(converter = FoodListConverter.class)
    private List<Food> foods;
    @Column(name = "settlement", length = 200)
    private String settlement;
    @Column(name = "public_domain", length = 200)
    private String publicDomain;
    @Column(name = "public_area_type", length = 200)
    private String typeOfPublicArea;
    @Column(name = "house_number", length = 200)
    private String houseNumber;

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getPublicDomain() {
        return publicDomain;
    }

    public void setPublicDomain(String publicDomain) {
        this.publicDomain = publicDomain;
    }

    public String getTypeOfPublicArea() {
        return typeOfPublicArea;
    }

    public void setTypeOfPublicArea(String typeOfPublicArea) {
        this.typeOfPublicArea = typeOfPublicArea;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
