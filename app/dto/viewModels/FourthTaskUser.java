package app.dto.viewModels;

import app.models.Product;
import com.google.gson.annotations.Expose;

import java.util.Set;

public class FourthTaskUser {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    @Expose
    private SoldProductsContainerView productContainer;

    public FourthTaskUser() {
        productContainer = new SoldProductsContainerView();
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

    public SoldProductsContainerView getProductContainer() {
        return productContainer;
    }

    public void setProductContainer(SoldProductsContainerView productContainer) {
        this.productContainer = productContainer;
    }
}
