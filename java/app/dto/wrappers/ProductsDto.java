package app.dto.wrappers;

import app.dto.add.ProductAddDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsDto {

    @XmlElement(name = "product")
    private List<ProductAddDto> products;

    public ProductsDto() {
    }

    public List<ProductAddDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductAddDto> products) {
        this.products = products;
    }
}
