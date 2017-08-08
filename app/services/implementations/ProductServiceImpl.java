package app.services.implementations;

import app.dto.bindingModels.ProductDto;
import app.dto.viewModels.ProductInRangeView;
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
    public void saveProduct(ProductDto productDto) {
        Product product = DtoMappingUtil.convert(productDto, Product.class);
        this.productRepository.save(product);
    }

    @Override
    public List<ProductDto> findAllProducts() {
        List<Product> products = this.productRepository.findAll();
        List<ProductDto> productDtos = DtoMappingUtil.convert(products, ProductDto.class);
        return productDtos;
    }

    @Override
    public List<ProductView> findAllViews() {
        List<Product> products = this.productRepository.findAll();
        List<ProductView> productViews = DtoMappingUtil.convert(products, ProductView.class);

        return productViews;
    }

    @Override
    public List<ProductInRangeView> findProductsInPriceRange() {
        List<Product> productsByPrice = this.productRepository.findProductsInPriceRange();
        List<ProductInRangeView> views = DtoMappingUtil.convert(productsByPrice, ProductInRangeView.class);
        return views;
    }
}
