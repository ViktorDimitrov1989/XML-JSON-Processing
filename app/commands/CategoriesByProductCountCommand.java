package app.commands;

import app.dto.viewModels.CategoryByProductCount;
import app.services.contracts.CategoryService;
import app.services.contracts.ProductService;
import app.services.contracts.UserService;
import app.utils.Constants;
import app.utils.JsonSerializer;

import java.util.List;

public class CategoriesByProductCountCommand extends Command {

    public CategoriesByProductCountCommand(CategoryService categoryService, ProductService productService, UserService userService, JsonSerializer jsonSerializer) {
        super(categoryService, productService, userService, jsonSerializer);
    }

    @Override
    public String execute(String... tokens) {
        List<CategoryByProductCount> categories = super.getCategoryService().getCategoriesByProductCount();

        for (CategoryByProductCount category : categories) {
            category.setProductsCount(category.getProductsCount());
            category.setAveragePrice(category.getAveragePrice());
            category.setTotalRevue(category.getTotalRevue());
        }

        super.getJsonSerializer().serialize(categories,
                Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_CATEGORIES_BY_PRODUCT_COUNT_FILE);


        return "Categories where exported to " +
                Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_CATEGORIES_BY_PRODUCT_COUNT_FILE;
    }
}
