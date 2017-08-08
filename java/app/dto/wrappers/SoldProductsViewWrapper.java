package app.dto.wrappers;

import app.dto.viewModels.ProductDtoView;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sold-products")
public class SoldProductsViewWrapper implements Serializable {

    @XmlElement(name = "product")
    private List<ProductDtoView> products;
    @XmlAttribute
    private int count;

    public SoldProductsViewWrapper() {
    }

    public List<ProductDtoView> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDtoView> products) {
        this.products = products;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
