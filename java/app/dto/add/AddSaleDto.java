package app.dto.add;

import com.google.gson.annotations.Expose;
public class AddSaleDto {
    @Expose
    private CarDto car;
    @Expose
    private CustomerDto customer;
    @Expose
    private double discountPercentage;

    public AddSaleDto() {
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }
}
