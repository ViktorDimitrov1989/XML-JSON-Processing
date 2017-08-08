package app.dto.bindingModels;

import app.models.Product;
import com.google.gson.annotations.Expose;

import java.util.Set;

public class CategoryDto {
    @Expose
    private Long id;
    @Expose
    private String name;

    private Set<Product> products;

    public CategoryDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
