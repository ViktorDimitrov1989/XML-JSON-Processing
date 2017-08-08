package app.commands;

import app.dto.viewModels.UsersContainer;
import app.services.contracts.CategoryService;
import app.services.contracts.ProductService;
import app.services.contracts.UserService;
import app.utils.Constants;
import app.utils.JsonSerializer;

public class UsersAndProductsCommand extends Command {

    public UsersAndProductsCommand(CategoryService categoryService, ProductService productService, UserService userService, JsonSerializer jsonSerializer) {
        super(categoryService, productService, userService, jsonSerializer);
    }

    @Override
    public String execute(String... tokens) {
        UsersContainer uc = super.getUserService().findAllUsersFourthTask();

        String debug = "";

        super.getJsonSerializer()
                .serialize(uc,
                        Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_USERS_AND_PRODUCTS_FILE);


        return "Task was completed, look for the result here: " + Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_USERS_AND_PRODUCTS_FILE;
    }
}
