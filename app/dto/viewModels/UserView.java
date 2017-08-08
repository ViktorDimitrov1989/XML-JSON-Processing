package app.dto.viewModels;

import app.dto.bindingModels.ProductDto;
import app.models.Product;
import com.google.gson.annotations.Expose;

import java.util.Set;

public class UserView {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    private Set<ProductDto> boughtProducts;
    private Set<ProductDto> soldProducts;

    public UserView() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<ProductDto> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(Set<ProductDto> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }

    public Set<ProductDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
