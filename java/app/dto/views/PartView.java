package app.dto.views;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartView {
    @Expose
    @SerializedName("Name")
    private String name;
    @Expose
    @SerializedName("Price")
    private double price;

    public PartView() {
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
}
