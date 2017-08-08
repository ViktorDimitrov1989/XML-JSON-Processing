package app.dto.viewModels;

import app.dto.wrappers.SoldProductsViewWrapper;
import app.models.Product;

import javax.persistence.Transient;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class UserView implements Serializable {
    @XmlAttribute(name = "first-name")
    private String firstName;
    @XmlAttribute(name = "last-name")
    private String lastName;
    @XmlAttribute(name = "age")
    private int age;
    @XmlElement(name = "sold-products")
    SoldProductsViewWrapper productsViewWrapper;
    @XmlTransient
    private Set<Product> soldProducts;

    public UserView() {
    }

    public SoldProductsViewWrapper getProductsViewWrapper() {
        return productsViewWrapper;
    }

    public void setProductsViewWrapper(SoldProductsViewWrapper productsViewWrapper) {
        this.productsViewWrapper = productsViewWrapper;
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

    public Set<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
