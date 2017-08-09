package app.dto.views;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customer")
public class SaleCustomer implements Serializable {
    @Expose
    @SerializedName("fullName")
    @XmlAttribute(name = "full-name")
    private String name;
    @Expose
    @XmlAttribute(name = "bought-cars")
    private int boughtCars;
    @Expose
    @XmlAttribute(name = "spent-money")
    private double spentMoney;

    public SaleCustomer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(int boughtCars) {
        this.boughtCars = boughtCars;
    }

    public double getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(double spentMoney) {
        this.spentMoney = spentMoney;
    }
}
