package app.services.implementations;

import app.dto.add.CategoryAddDto;
import app.dto.bindingModels.CategoryDto;
import app.dto.viewModels.CategoryByProductView;
import app.dto.wrappers.CategoryByProductWrapper;
import app.models.Category;
import app.models.Product;
import app.repositories.CategoryRepository;
import app.services.contracts.CategoryService;
import app.utils.DtoMappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void saveCategory(CategoryAddDto categoryDto) {
        this.categoryRepository.saveAndFlush(DtoMappingUtil.convert(categoryDto, app.models.Category.class));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return DtoMappingUtil.convert(this.categoryRepository.findAll(), CategoryDto.class);
    }

    @Override
    public CategoryByProductWrapper caterogiresByProductCount() {
        CategoryByProductWrapper wrapper = new CategoryByProductWrapper();
        List<Category> categories = this.categoryRepository.caterogiresByProductCount();

        for (Category category : categories) {
            CategoryByProductView cat = DtoMappingUtil.convert(category, CategoryByProductView.class);
            cat.setProductCount(cat.getProducts().size());
            cat.setAveragePrice(cat.getProducts().stream().mapToDouble(Product::getPrice).sum() / cat.getProducts().size());
            cat.setTotalRevenue(cat.getProducts().stream().mapToDouble(Product::getPrice).sum());
            wrapper.getCategories().add(cat);
        }

        return wrapper;
    }


}
