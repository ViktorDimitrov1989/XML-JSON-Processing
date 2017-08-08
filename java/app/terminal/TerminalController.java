package app.terminal;

import app.dto.add.CategoryAddDto;
import app.dto.add.ProductAddDto;
import app.dto.add.UserAddDto;
import app.dto.bindingModels.CategoryDto;
import app.dto.bindingModels.UserDto;
import app.dto.viewModels.ProductView;
import app.dto.viewModels.SellerView;
import app.dto.viewModels.UserView;
import app.dto.wrappers.*;
import app.services.contracts.CategoryService;
import app.services.contracts.ProductService;
import app.services.contracts.UserService;
import app.utils.Constants;
import app.utils.JsonSerializer;
import app.utils.XmlSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Component
public class TerminalController implements CommandLineRunner {
    private CategoryService categoryService;
    private UserService userService;
    private ProductService productService;
    private JsonSerializer jsonSerializer;
    private XmlSerializer xmlSerializer;

    @Autowired
    public TerminalController(CategoryService categoryService,
                              UserService userService,
                              ProductService productService,
                              JsonSerializer jsonSerializer, XmlSerializer xmlSerializer) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
    }

    @Override
    public void run(String... strings) throws Exception {
        //1//
        seedDatabase();
        //2//
        exportProductsInRange();
        //3 Successfully sold products//
        exportSuccessfullySoldProducts();
        //4 categoriesByProductCount//
        exportCategoriesByProductCount();
        //5 Users and products//
        exportUsersAndProducts();


    }

    private void exportUsersAndProducts() {
        List<UserView> users = this.userService.findAllSuccessSellers();

        UsersViewWrapper usersWrapper = new UsersViewWrapper();
        usersWrapper.setUsers(users);
        usersWrapper.setCount(users.size());

        String debug = "";


        this.xmlSerializer.serialize(usersWrapper,
                Constants.OUTPUT_XML_FILES_PATH + Constants.OUTPUT_XML_USERS_AND_PRODUCTS_FILE);

    }

    private void exportCategoriesByProductCount() {
        CategoryByProductWrapper categories = this.categoryService.caterogiresByProductCount();

        this.xmlSerializer.serialize(categories,
                Constants.OUTPUT_XML_FILES_PATH + Constants.OUTPUT_XML_CATEGORIES_BY_PTODUCTS_FILE);

    }

    private void exportSuccessfullySoldProducts() {
        List<SellerView> sellers = this.userService.getSuccessfullySellers();
        SellerViewWrapper sellerViewWrapper = new SellerViewWrapper();
        sellerViewWrapper.setSellers(sellers);

        this.xmlSerializer.serialize(sellerViewWrapper,
                Constants.OUTPUT_XML_FILES_PATH + Constants.OUTPUT_XML_USERS_SOLD_PRODUCTS_FILE);
    }

    private void exportProductsInRange() {
        List<ProductView> products = this.productService.findProductsInRange();

        for (ProductView product : products) {
            product.setSellerFullName(product.getSeller().getFirstName() + " " + product.getSeller().getLastName());
        }

        ProductsViewWrapper pWrapper = new ProductsViewWrapper();
        pWrapper.setProducts(products);

        this.xmlSerializer.serialize(pWrapper,
                Constants.OUTPUT_XML_FILES_PATH + Constants.OUTPUT_XML_PRODUCTS_IN_RANGE_FILE);
    }

    private void seedDatabase() {
        importUsers();
        importCategories();
        importProducts();
    }


    private void importUsers() {
        UsersDto usersDto = this.xmlSerializer.deserialize(UsersDto.class,
                Constants.INPUT_XML_FILES_PATH + Constants.INPUT_XML_USERS_FILE);

        String debug = "";

        for (UserAddDto userDto : usersDto.getUsers()) {
            this.userService.saveUser(userDto);
        }

    }

    private void importCategories() {
        CategoriesDto categories = this.xmlSerializer.deserialize(CategoriesDto.class,
                Constants.INPUT_XML_FILES_PATH + Constants.INPUT_XML_CATEGORIES_FILE);

        for (CategoryAddDto category : categories.getCategories()) {
            this.categoryService.saveCategory(category);
        }
    }

    private void importProducts() {
        List<UserDto> users = this.userService.getAllUsers();
        List<CategoryDto> categories = this.categoryService.getAllCategories();

        String debug = "";

        ProductsDto products = this.xmlSerializer.deserialize(ProductsDto.class,
                Constants.INPUT_XML_FILES_PATH + Constants.INPUT_XML_PRODUCTS_FILE);

        int count = 0;
        Random random = new Random();
        for (ProductAddDto productDto : products.getProducts()) {
            int buyerIndex = random.nextInt(users.size());
            int sellerIndex = random.nextInt(users.size());
            UserDto buyer = users.get(buyerIndex);
            UserDto seller = users.get(sellerIndex);
            if (buyerIndex == sellerIndex) {
                buyer = null;
            }
            if (buyer != null && (count++ % 10) == 0) {
                buyer = null;
            }
            Set<CategoryDto> randomCats = generateRandomCategories(categories);

            productDto.setBuyer(buyer);
            productDto.setSeller(seller);
            productDto.setCategories(randomCats);

            this.productService.saveProduct(productDto);
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
