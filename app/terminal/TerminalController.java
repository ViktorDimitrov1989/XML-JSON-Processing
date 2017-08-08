package app.terminal;

import app.commands.CommandFactoryImpl;
import app.commands.Executable;
import app.services.contracts.CategoryService;
import app.services.contracts.ProductService;
import app.services.contracts.UserService;
import app.services.implementations.CategoryServiceImpl;
import app.services.implementations.ProductServiceImpl;
import app.services.implementations.UserServiceImpl;
import app.utils.JsonSerializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class TerminalController implements CommandLineRunner {
    private CategoryService categoryService;
    private UserService userService;
    private ProductService productService;

    private JsonSerializer jsonSerializer;

    public TerminalController(CategoryServiceImpl categoryService, UserServiceImpl userService, ProductServiceImpl productService, JsonSerializer jsonSerializer) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.jsonSerializer = jsonSerializer;
    }


    //commands to write in the terminal:
    //1. SeedDatabase
    //2. ExportProductsInRange
    //3. SuccessfullySoldProducts
    //4. CategoriesByProductCount
    //5. UsersAndProducts


    @Override
    public void run(String... strings) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String c = reader.readLine();

        CommandFactoryImpl commandFactory = new CommandFactoryImpl(this.categoryService, this.userService, this.productService, this.jsonSerializer);
        Executable command = commandFactory.generateCommand(c);
        String result = command.execute();
        System.out.println(result);
    }

}
