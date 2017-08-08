package app.dto.views;

import app.models.Car;
import app.models.Customer;
import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class OrderedSale implements Serializable{
    @Expose
    private Long id;
    @Expose
    private Car car;
    private Customer customer;
    @Expose
    private double discountPercentage;

    public OrderedSale() {
    }

    public Long getId() {        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
