package app.dto.viewModels;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class ProductView {
    @Expose
    private String name;
    @Expose
    private double price;
    @Expose
    private UserView buyer;
    @Expose
    private UserView seller;
    @Expose
    private Date date;

    public ProductView() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UserView getBuyer() {
        return buyer;
    }

    public void setBuyer(UserView buyer) {
        this.buyer = buyer;
    }

    public UserView getSeller() {
        return seller;
    }

    public void setSeller(UserView seller) {
        this.seller = seller;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
