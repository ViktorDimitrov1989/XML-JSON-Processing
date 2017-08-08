package app.dto.bindingModels;

import com.google.gson.annotations.Expose;

import java.util.Set;

public class ProductDto {
    @Expose
    private String name;
    @Expose
    private double price;
    @Expose
    private UserDto buyer;
    @Expose
    private UserDto seller;
    @Expose
    private Set<CategoryDto> categories;

    public ProductDto() {
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

    public UserDto getBuyer() {
        return buyer;
    }

    public void setBuyer(UserDto buyer) {
        this.buyer = buyer;
    }

    public UserDto getSeller() {
        return seller;
    }

    public void setSeller(UserDto seller) {
        this.seller = seller;
    }

    public Set<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryDto> categories) {
        this.categories = categories;
    }
}
