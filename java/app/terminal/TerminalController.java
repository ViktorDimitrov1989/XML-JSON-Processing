package app.terminal;

import app.dto.add.*;
import app.dto.views.*;
import app.services.*;
import app.utils.Constants;
import app.utils.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class TerminalController implements CommandLineRunner {
    //services and utils comes here autowire them
    private PartSupplierService partSupplierService;
    private PartsService partsService;
    private CarService carService;
    private CustomerService customerService;
    private SalesService salesService;

    //utils
    private JsonSerializer jsonSerializer;


    @Autowired
    public TerminalController(PartSupplierService partSupplierService,
                              PartsService partsService,
                              CarService carService,
                              CustomerService customerService,
                              SalesService salesService,
                              JsonSerializer jsonSerializer) {
        this.partSupplierService = partSupplierService;
        this.partsService = partsService;
        this.carService = carService;
        this.customerService = customerService;
        this.salesService = salesService;
        this.jsonSerializer = jsonSerializer;
    }

    @Override
    public void run(String... strings) throws Exception {
        //4/5//
        //importData();
        //6.1 Ordered Customers//
        //orderedCustomers();
        //6.2 Cars From Toyota//
        //findAllToyotas();
        //6.3 Local suppliers///
        //findLocalSuppliers();
        //6.4 Cars With their list of parts//
        //exportAllCarsWithParts();
        //6.5//
        //exportCustomersByBoughtcars();
        //6.6//
        salesWithAppliedDiscount();

    }

    private void salesWithAppliedDiscount() {
        List<SaleWithDiscount> sales =
               this.salesService.getSalesWithAppliedDiscount();

        this.jsonSerializer.serialize(sales,
                Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_SALES_DISCOUNTS_FILE);

    }

    private void exportCustomersByBoughtcars() {
        List<SaleCustomer> customers = this.customerService.customersByBoughtCars();

        customers = customers
                .stream()
                .sorted((a,b) -> {
            int res = Double.compare(b.getSpentMoney(), a.getSpentMoney());

            if (res == 0){
                res = Integer.compare(b.getBoughtCars(), a.getBoughtCars());
            }

            return res;
        }).collect(Collectors.toList());


        this.jsonSerializer.serialize(customers,
                Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_SALES_BY_CUSTOMER_FILE);

    }

    private void exportAllCarsWithParts() {
        List<CarView> cars = this.carService.findAllWithParts();

        String debug = "";

        this.jsonSerializer.serialize(cars,
                Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_CARS_AND_PARTS_FILE);

    }

    private void findLocalSuppliers() {
        List<LocalSupplier> suppliers = this.partSupplierService.findAllByImporterIsFlase();

        for (LocalSupplier supplier : suppliers) {
            supplier.setPartsCount(supplier.getParts().size());
        }

        String debug = "";

        this.jsonSerializer.serialize(suppliers,
                Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_LOCAL_SUPPLIERS_FILE);

    }

    private void findAllToyotas() {
        List<ToyotaView> toyotas = this.carService.getAllToyotas();

        this.jsonSerializer.serialize(toyotas,
                Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_TOYOTA_CARS_FILE);
    }

    private void orderedCustomers() {
        List<OrderedCustomer> customers = this.customerService.findAllByOrderByBirthDateAsc();

        String debug = "";

        this.jsonSerializer.serialize(customers,
                Constants.OUTPUT_JSON_FILES_PATH + Constants.OUTPUT_JSON_ORDERED_CUSTOMERS_FILE);
    }

    private void importData() {
        importSuppliers();
        importParts();
        importCars();
        importCustomers();
        importSales();
    }

    private void importSales() {
        List<CustomerDto> customers = this.customerService.getCustomersToSet();
        List<CarDto> cars = this.carService.getCarsToSet();

        double[] discounts = new double[]{0,0.5,0.15,0.20,0.30,0.40};
        Random rnd = new Random();

        for (int i = 0; i < 100; i++) {
            AddSaleDto sale = new AddSaleDto();
            CarDto car = cars.get(rnd.nextInt(cars.size()));
            sale.setCar(car);
            sale.setCustomer(customers.get(rnd.nextInt(customers.size())));
            sale.setDiscountPercentage(discounts[rnd.nextInt(discounts.length)]);
            this.salesService.saveSale(sale);
        }
    }

    private void importCustomers() {
        AddCustomerDto[] customers = this.jsonSerializer.deserialize(AddCustomerDto[].class,
                Constants.INPUT_JSON_FILES_PATH + Constants.INPUT_JSON_CUSTOMERS_FILE);

        for (AddCustomerDto customer : customers) {
            this.customerService.saveCutomer(customer);
        }
    }

    private void importCars() {
        List<PartDto> parts = this.partsService.findAllPartsId();

        String debug = "";

        AddCarDto[] cars = this.jsonSerializer.deserialize(AddCarDto[].class,
                Constants.INPUT_JSON_FILES_PATH + Constants.INPUT_JSON_CARS_FILE);

        Random random = new Random();
        List<PartDto> randomParts = new ArrayList<>();
        for (AddCarDto car : cars) {

            int endIndex = random.nextInt(20);
            for (int i = 10; i < endIndex; i++) {
                randomParts.add(parts.get(random.nextInt(parts.size())));
            }

            car.setParts(randomParts);
            this.carService.saveCar(car);
            randomParts.clear();
        }

    }

    private void importParts() {
        List<PartSupplierDto> suppliers = this.partSupplierService.findAllSuppliers();

        AddPartDto[] parts = this.jsonSerializer.deserialize(AddPartDto[].class,
                Constants.INPUT_JSON_FILES_PATH + Constants.INPUT_JSON_PARTS_FILE);

        Random rnd = new Random();
        for (AddPartDto part : parts) {
            part.setSupplier(suppliers.get(rnd.nextInt(suppliers.size())));
            this.partsService.savePart(part);
        }
    }

    private void importSuppliers() {
        AddPartSupplierDto[] partSuppliers = this.jsonSerializer.deserialize(AddPartSupplierDto[].class,
                Constants.INPUT_JSON_FILES_PATH + Constants.INPUT_JSON_SUPPLIERS_FILE);

        for (AddPartSupplierDto partSupplier : partSuppliers) {
            this.partSupplierService.savePartSupplier(partSupplier);
        }
    }


}
