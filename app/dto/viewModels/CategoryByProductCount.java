package app.dto.viewModels;

import app.models.Product;
import com.google.gson.annotations.Expose;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CategoryByProductCount {
    @Expose
    private String name;
    @Expose
    private int productsCount;
    @Expose
    private double averagePrice;
    @Expose
    private double totalRevue;

    private Set<Product> products;

    public CategoryByProductCount() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductsCount() {
        return this.products.size();
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public double getAveragePrice() {
        double res = this.products
                .stream().mapToDouble(x -> x.getPrice()).sum() / this.products.size();
        
        return res;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public double getTotalRevue() {
        double res = this.products
                .stream().mapToDouble(x -> x.getPrice()).sum();


        return res;
    }

    public void setTotalRevue(double totalRevue) {
        this.totalRevue = totalRevue;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
