package app.commands;

import app.dto.viewModels.ProductInRangeView;
import app.dto.viewModels.ProductView;
import app.dto.viewModels.Seller;
import app.services.contracts.CategoryService;
import app.services.contracts.ProductService;
import app.services.contracts.UserService;
import app.utils.Constants;
import app.utils.JsonSerializer;

import java.util.Date;
import java.util.List;

public class ExportProductsInRangeCommand extends Command {

    public ExportProductsInRangeCommand(CategoryService categoryService, ProductService productService, UserService userService, JsonSerializer jsonSerializer) {
        super(categoryService, productService, userService, jsonSerializer);
    }

    @Override
    public String execute(String... tokens) {
        List<ProductInRangeView> productViews = super.getProductService().findProductsInPriceRange();

        String debug = "";

        for (ProductInRangeView product : productViews) {
            Seller seller = new Seller();

            seller.setFullName(product.getSeller().getFirstName() + " " + product.getSeller().getLastName());

            product.setSeller(seller);
        }

        this.getJsonSerializer()
                .serialize(productViews, Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_PRODUCTS_IN_RANGE_FILE);

        return "Products where exported to " + Constants.OUTPUT_JSON_PRODUCTS_IN_RANGE_FILE;
    }
}
