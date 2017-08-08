package app.dto.viewModels;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class SoldProductsContainerView {
    @Expose
    private int count;
    @Expose
    private List<FourthTaskProductViewModel> products;


    public SoldProductsContainerView() {
        products = new ArrayList<>();
    }

    public List<FourthTaskProductViewModel> getProducts() {
        return products;
    }

    public void setProducts(List<FourthTaskProductViewModel> products) {
        this.products = products;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
