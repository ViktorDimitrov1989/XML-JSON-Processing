package app.commands;

import app.dto.viewModels.ProductView;
import app.services.contracts.CategoryService;
import app.services.contracts.ProductService;
import app.services.contracts.UserService;
import app.utils.Constants;
import app.utils.JsonSerializer;

import java.util.Date;
import java.util.List;

public class ExportProductsCommand extends Command {

    public ExportProductsCommand(CategoryService categoryService, ProductService productService, UserService userService, JsonSerializer jsonSerializer) {
        super(categoryService, productService, userService, jsonSerializer);
    }

    @Override
    public String execute(String... tokens) {
        exportProducts();

        return "Products where exported to " + Constants.OUTPUT_JSON_PRODUCTS_FILE;
    }


    private void exportProducts(){
        List<ProductView> productViews = super.getProductService().findAllViews();

        for (ProductView productView : productViews) {
            productView.setDate(new Date());
        }

        this.getJsonSerializer()
                .serialize(productViews, Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_PRODUCTS_FILE);
    }

}
