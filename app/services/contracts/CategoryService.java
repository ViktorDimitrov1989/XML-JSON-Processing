package app.services.contracts;

import app.dto.bindingModels.CategoryDto;
import app.dto.viewModels.CategoryByProductCount;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    void saveCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();

    List<CategoryByProductCount> getCategoriesByProductCount();

}
