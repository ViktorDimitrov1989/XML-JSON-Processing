package app.dto.views;

import app.models.Sale;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class OrderedCustomer implements Serializable {
    @Expose
    @SerializedName("Id")
    private Long id;
    @Expose
    @SerializedName("Name")
    private String name;
    @Expose
    @SerializedName("BirthDate")
    private Date birthDate;
    @Expose
    @SerializedName("IsYoungDriver")
    private boolean isYoungDriver;
    @Expose
    @SerializedName("Sales")
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
