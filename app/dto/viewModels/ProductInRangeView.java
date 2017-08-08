package app.dto.viewModels;

import app.models.User;
import com.google.gson.annotations.Expose;

public class ProductInRangeView {
    @Expose
    private String name;
    @Expose
    private double price;
    @Expose
    private Seller seller;

    public ProductInRangeView() {
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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
