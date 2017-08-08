package app.services.implementations;

import app.dto.bindingModels.CategoryDto;
import app.dto.viewModels.CategoryByProductCount;
import app.models.Category;
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
    public void saveCategory(CategoryDto categoryDto) {
        this.categoryRepository.saveAndFlush(DtoMappingUtil.convert(categoryDto, Category.class));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();

        return DtoMappingUtil.convert(categories, CategoryDto.class);
    }

    @Override
    public List<CategoryByProductCount> getCategoriesByProductCount() {
        List<Category> categories = this.categoryRepository.caterogiresByProductCount();
        List<CategoryByProductCount> res = DtoMappingUtil.convert(categories, CategoryByProductCount.class);
        return res;
    }
}
