package hu.ulyssys.java.course.food.delivery.entity;

import java.util.Date;
import java.util.List;

public class Order extends AbstractModifiableEntity {
    private Date deliveryDate;

    private Courier courier;

    private List<Food> foods;

    private String settlement;

    private String publicDomain;

    private String typeOfPublicArea;

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
