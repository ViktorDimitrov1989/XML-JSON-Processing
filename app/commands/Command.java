package app.commands;

import app.services.contracts.CategoryService;
import app.services.contracts.ProductService;
import app.services.contracts.UserService;
import app.utils.JsonSerializer;

public abstract class Command implements Executable{
    private CategoryService categoryService;
    private ProductService productService;
    private UserService userService;

    private JsonSerializer jsonSerializer;

    public Command(CategoryService categoryService, ProductService productService, UserService userService, JsonSerializer jsonSerializer) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userService = userService;
        this.jsonSerializer = jsonSerializer;
    }

    protected CategoryService getCategoryService() {
        return categoryService;
    }

    protected ProductService getProductService() {
        return productService;
    }

    protected UserService getUserService() {
        return userService;
    }

    public JsonSerializer getJsonSerializer() {
        return jsonSerializer;
    }
}
