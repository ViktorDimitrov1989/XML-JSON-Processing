package app.commands;

import app.dto.bindingModels.CategoryDto;
import app.dto.bindingModels.ProductDto;
import app.dto.bindingModels.UserDto;
import app.dto.viewModels.ProductView;
import app.services.contracts.CategoryService;
import app.services.contracts.ProductService;
import app.services.contracts.UserService;
import app.utils.Constants;
import app.utils.JsonSerializer;

import java.util.*;

public class SeedDatabaseCommand extends Command {

    public SeedDatabaseCommand(CategoryService categoryService, ProductService productService, UserService userService, JsonSerializer jsonSerializer) {
        super(categoryService, productService, userService, jsonSerializer);
    }

    @Override
    public String execute(String... tokens) {
        importUsers();
        importCategories();
        importProducts();

        return "Problem 1 was executed! See your HeidiSQL client for the results";
    }



    private void importUsers() {
        UserDto[] userDtos = super.getJsonSerializer().deserialize(UserDto[].class,
                Constants.INPUT_JSON_FILES_PATH + Constants.INPUT_JSON_USERS_FILE);

        for (UserDto userDto : userDtos) {
            super.getUserService().saveUser(userDto);
        }
    }

    private void importCategories(){
        String debug = "";

        CategoryDto[] categoryDtos = super.getJsonSerializer().deserialize(CategoryDto[].class,
                Constants.INPUT_JSON_FILES_PATH + Constants.INPUT_JSON_CATEGORIES_FILE);

        for (CategoryDto categoryDto : categoryDtos) {
            super.getCategoryService().saveCategory(categoryDto);
        }

    }

    private void importProducts(){
        List<UserDto> users = this.getUserService().getAllUsers();
        List<CategoryDto> categoryDtos = super.getCategoryService().getAllCategories();
        ProductDto[] productDtos = super.getJsonSerializer().deserialize(ProductDto[].class,
                Constants.INPUT_JSON_FILES_PATH + Constants.INPUT_JSON_PRODUCTS_FILE);

        Random random = new Random();
        for (ProductDto productDto : productDtos) {
            int buyerIndex = random.nextInt(users.size());
            int sellerIndex = random.nextInt(users.size());
            UserDto buyer = users.get(buyerIndex);
            UserDto seller = users.get(sellerIndex);
            if(buyerIndex == sellerIndex){
                buyer = null;
            }
            if(buyer != null && buyer.getLastName().length() < 5){
                buyer = null;
            }
            Set<CategoryDto> randomCats = generateRandomCategories(categoryDtos);

            productDto.setBuyer(buyer);
            productDto.setSeller(seller);
            productDto.setCategories(randomCats);

            super.getProductService().saveProduct(productDto);
        }
    }

    private Set<CategoryDto> generateRandomCategories(List<CategoryDto> categoryDtos) {
        Set<CategoryDto> res = new HashSet<>();

        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(categoryDtos.size());

            res.add(categoryDtos.get(randomIndex));
        }

        return res;
    }

}
