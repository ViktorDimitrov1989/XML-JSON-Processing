package app.commands;

import app.dto.viewModels.SuccessSeller;
import app.services.contracts.CategoryService;
import app.services.contracts.ProductService;
import app.services.contracts.UserService;
import app.utils.Constants;
import app.utils.JsonSerializer;

import java.util.List;

public class SuccessfullySoldProductsCommand extends Command {

    public SuccessfullySoldProductsCommand(CategoryService categoryService,
                                           ProductService productService,
                                           UserService userService,
                                           JsonSerializer jsonSerializer) {
        super(categoryService, productService, userService, jsonSerializer);
    }

    @Override
    public String execute(String... tokens) {
        List<SuccessSeller> sellers = super.getUserService().getAllSuccessSellers();

        super.getJsonSerializer()
                .serialize(sellers,
                        Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_SUCCESSFULLY_SOLD_PRODUCTS_FILE);

        return "Task 3.1 completed - look at file: " + Constants.OUTPUT_JSON_SUCCESSFULLY_SOLD_PRODUCTS_FILE;
    }
}
