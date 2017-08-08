package app.dto.views;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class SaleWithDiscount implements Serializable{
    @Expose
    private CarWithDiscount car;
    @Expose
    private CustomerWithDiscount customer;
    @Expose
    private double discountPercentage;

    public SaleWithDiscount() {
    }

    public CarWithDiscount getCar() {
        return car;
    }

    public void setCar(CarWithDiscount car) {
        this.car = car;
    }

    public CustomerWithDiscount getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerWithDiscount customer) {
        this.customer = customer;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
