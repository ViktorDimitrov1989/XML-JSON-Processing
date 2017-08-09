package app.dto.views;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sale")
public class SaleWithDiscount implements Serializable{
    @Expose
    @XmlElement(name = "car")
    private CarWithDiscount car;
    @Expose
    //@XmlElement(name = "customer")
    @XmlTransient
    private CustomerWithDiscount customer;
    //--//
    @Expose
    @SerializedName("customerName")
    @XmlElement(name = "customer-name")
    private String customerName;
    @Expose
    @SerializedName("Discount")
    @XmlElement(name = "discount")
    private double customerDiscountPercentage;
    @Expose
    @XmlElement(name = "price")
    private double customerPrice;
    @Expose
    @XmlElement(name = "price-with-discount")
    private double customerPriceWithDiscount;
    @XmlTransient
    private Date customerBirthDate;
    //--//
    @Expose
    @XmlTransient
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getCustomerDiscountPercentage() {
        return customerDiscountPercentage;
    }

    public void setCustomerDiscountPercentage(double customerDiscountPercentage) {
        this.customerDiscountPercentage = customerDiscountPercentage;
    }

    public double getCustomerPriceWithDiscount() {
        return customerPriceWithDiscount;
    }

    public void setCustomerPriceWithDiscount(double customerPriceWithDiscount) {
        this.customerPriceWithDiscount = customerPriceWithDiscount;
    }

    public double getCustomerPrice() {
        return customerPrice;
    }

    public void setCustomerPrice(double customerPrice) {
        this.customerPrice = customerPrice;
    }

    public Date getCustomerBirthDate() {
        return customerBirthDate;
    }

    public void setCustomerBirthDate(Date customerBirthDate) {
        this.customerBirthDate = customerBirthDate;
    }
}
