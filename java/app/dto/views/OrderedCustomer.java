package app.dto.views;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customer")
public class OrderedCustomer implements Serializable {
    @Expose
    @SerializedName("Id")
    @XmlElement(name = "id")
    private Long id;
    @Expose
    @SerializedName("Name")
    @XmlElement(name = "name")
    private String name;
    @Expose
    @SerializedName("BirthDate")
    @XmlElement(name = "birth-date")
    private Date birthDate;
    @Expose
    @SerializedName("IsYoungDriver")
    @XmlElement(name = "is-youn-driver")
    private boolean isYoungDriver;
    @Expose
    @SerializedName("Sales")
    @XmlTransient
    private Set<OrderedSale> sales;

    public OrderedCustomer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Set<OrderedSale> getSales() {
        return sales;
    }

    public void setSales(Set<OrderedSale> sales) {
        this.sales = sales;
    }
}
