package app.commands;
import app.services.contracts.CategoryService;
import app.services.contracts.ProductService;
import app.services.contracts.UserService;
import app.utils.JsonSerializer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class CommandFactoryImpl{

    private static final String COMMANDS_PACKAGE_DESTINATION = "app.commands.";
    private CategoryService categoryService;
    private UserService userService;
    private ProductService productService;
    private JsonSerializer jsonSerializer;

    public CommandFactoryImpl(CategoryService categoryService,
                              UserService userService,
                              ProductService productService,
                              JsonSerializer jsonSerializer) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.jsonSerializer = jsonSerializer;
    }

    public Executable generateCommand(String command) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {

        Class<?> commandClass = Class.forName(COMMANDS_PACKAGE_DESTINATION + command + "Command");
        Constructor<?> constructor = commandClass.getDeclaredConstructor(CategoryService.class,
                ProductService.class,
                UserService.class,
                JsonSerializer.class);
        Command com = (Command) constructor.newInstance(this.categoryService, this.productService, this.userService, this.jsonSerializer);

        return com;
    }

}
