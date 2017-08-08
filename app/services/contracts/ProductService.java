package app.services.contracts;

import app.dto.bindingModels.ProductDto;
import app.dto.viewModels.ProductInRangeView;
import app.dto.viewModels.ProductView;
import app.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    void saveProduct(ProductDto productDto);

    List<ProductDto> findAllProducts();

    List<ProductView> findAllViews();

    List<ProductInRangeView> findProductsInPriceRange();

}
