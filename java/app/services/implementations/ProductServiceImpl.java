package app.services.implementations;

import app.dto.add.ProductAddDto;
import app.dto.viewModels.ProductView;
import app.models.Product;
import app.repositories.ProductRepository;
import app.services.contracts.ProductService;
import app.utils.DtoMappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(ProductAddDto productDto) {
        this.productRepository.saveAndFlush(DtoMappingUtil.convert(productDto, Product.class));
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public List<ProductView> findProductsInRange() {
        List<Product> products = this.productRepository.findProductsInPriceRange();

        return DtoMappingUtil.convert(products, ProductView.class);
    }
}
