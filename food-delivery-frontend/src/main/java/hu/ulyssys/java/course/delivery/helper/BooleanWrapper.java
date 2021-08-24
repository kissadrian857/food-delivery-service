package hu.ulyssys.java.course.delivery.helper;

public class BooleanWrapper {
    private Boolean boolValue;

    public Boolean getBoolValue() {
        return boolValue;
    }

    public void setBoolValue(Boolean boolValue) {
        this.boolValue = boolValue;
    }

    public BooleanWrapper(Boolean boolValue) {
        this.boolValue = boolValue;
    }
}
