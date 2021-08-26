package hu.ulyssys.java.course.delivery.rest.model;

import java.util.Date;
import java.util.List;

public class OrderRestModel extends CoreRestModel{
    private Date deliveryDate;

    private Long courierId;

    private List<FoodRestModel> foods;

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

    public Long getCourierId() {
        return courierId;
    }

    public void setCourierId(Long courierId) {
        this.courierId = courierId;
    }

    public List<FoodRestModel> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodRestModel> foods) {
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

    public void addFoodModel(FoodRestModel foodModel){
        foods.add(foodModel);
    }
}
