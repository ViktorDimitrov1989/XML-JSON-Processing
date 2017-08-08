package app.services.contracts;

import app.dto.add.ProductAddDto;
import app.dto.viewModels.ProductView;
import app.models.Product;

import java.util.List;

public interface ProductService {

    void saveProduct(ProductAddDto productDto);

    List<Product> findAll();

    List<ProductView> findProductsInRange();
}
