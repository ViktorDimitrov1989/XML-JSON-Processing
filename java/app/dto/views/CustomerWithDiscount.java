package app.dto.views;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerWithDiscount implements Serializable {
    @Expose
    @SerializedName("customerName")
    @XmlElement(name = "customer-name")
    private String name;
    @Expose
    @SerializedName("Discount")
    @XmlElement(name = "discount")
    private double discountPercentage;
    @Expose
    @XmlElement(name = "price")
    private double price;
    @Expose
    @XmlElement(name = "price-with-discount")
    private double priceWithDiscount;
    @XmlTransient
    private Date birthDate;

    public CustomerWithDiscount() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(double priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
