package app.services.contracts;

import app.dto.add.CategoryAddDto;
import app.dto.bindingModels.CategoryDto;
import app.dto.wrappers.CategoryByProductWrapper;

import java.util.List;


public interface CategoryService {

    void saveCategory(CategoryAddDto categoryDto);

    List<CategoryDto> getAllCategories();

    CategoryByProductWrapper caterogiresByProductCount();
}
