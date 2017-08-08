package app.dto.wrappers;

import app.dto.viewModels.ProductView;
import app.dto.viewModels.SoldProductView;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.FIELD)
public class SoldProductsView implements Serializable{

    @XmlElement(name = "product")
    private List<SoldProductView> products;

    public SoldProductsView() {
    }

    public List<SoldProductView> getProducts() {
        return products;
    }

    public void setProducts(List<SoldProductView> products) {
        this.products = products;
    }

}
