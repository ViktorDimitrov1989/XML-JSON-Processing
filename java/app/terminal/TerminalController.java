package app.terminal;

import app.dto.add.*;
import app.dto.views.*;
import app.dto.wrapers.*;
import app.services.*;
import app.utils.Constants;
import app.utils.JsonSerializer;
import app.utils.XmlSerializer;
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
    private XmlSerializer xmlSerializer;


    @Autowired
    public TerminalController(PartSupplierService partSupplierService,
                              PartsService partsService,
                              CarService carService,
                              CustomerService customerService,
                              SalesService salesService,
                              JsonSerializer jsonSerializer,
                              XmlSerializer xmlSerializer) {
        this.partSupplierService = partSupplierService;
        this.partsService = partsService;
        this.carService = carService;
        this.customerService = customerService;
        this.salesService = salesService;
        this.jsonSerializer = jsonSerializer;
        this.xmlSerializer = xmlSerializer;
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

        SalesWithDiscountWrapper salesWrapper = new SalesWithDiscountWrapper();
        salesWrapper.setSales(sales);

        this.xmlSerializer.serialize(salesWrapper,
                Constants.OUTPUT_XML_FILES_PATH + Constants.OUTPUT_XML_SALES_DISCOUNTS_FILE);

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

        SaleCustomerWrapper customerWrapper = new SaleCustomerWrapper();
        customerWrapper.setCustomers(customers);

        this.xmlSerializer.serialize(customerWrapper,
                Constants.OUTPUT_XML_FILES_PATH + Constants.OUTPUT_XML_SALES_BY_CUSTOMER_FILE);

    }

    private void exportAllCarsWithParts() {
        List<CarView> cars = this.carService.findAllWithParts();

        CarWithPartsWrapper carsWrapper = new CarWithPartsWrapper();
        carsWrapper.setCars(cars);

        String debug = "";

        this.xmlSerializer.serialize(carsWrapper,
                Constants.OUTPUT_XML_FILES_PATH + Constants.OUTPUT_XML_CARS_AND_PARTS_FILE);

    }

    private void findLocalSuppliers() {
        List<LocalSupplier> suppliers = this.partSupplierService.findAllByImporterIsFlase();

        for (LocalSupplier supplier : suppliers) {
            supplier.setPartsCount(supplier.getParts().size());
        }

        LocalSupplierWrapper supplierWrapper = new LocalSupplierWrapper();
        supplierWrapper.setSuppliers(suppliers);

        this.xmlSerializer.serialize(supplierWrapper,
                Constants.OUTPUT_XML_FILES_PATH + Constants.OUTPUT_XML_LOCAL_SUPPLIERS_FILE);
    }

    private void findAllToyotas() {
        List<ToyotaView> toyotas = this.carService.getAllToyotas();

        ToyotaWrapper cars = new ToyotaWrapper();
        cars.setCars(toyotas);

        this.xmlSerializer.serialize(cars,
                Constants.OUTPUT_XML_FILES_PATH + Constants.OUTPUT_XML_TOYOTA_CARS_FILE);
    }

    private void orderedCustomers() {
        List<OrderedCustomer> customers = this.customerService.findAllByOrderByBirthDateAsc();

        OrderedCustomersWrapper customersWrapper = new OrderedCustomersWrapper();
        customersWrapper.setCustomers(customers);

        this.xmlSerializer.serialize(customersWrapper,
                Constants.OUTPUT_XML_FILES_PATH + Constants.OUTPUT_XML_ORDERED_CUSTOMERS_FILE);
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
        AddCustomerWrapper customersWrapper = this.xmlSerializer.deserialize(AddCustomerWrapper.class,
                Constants.INPUT_XML_FILES_PATH + Constants.INPUT_XML_CUSTOMERS_FILE);

        for (AddCustomerDto customer : customersWrapper.getCustomers()) {
            this.customerService.saveCutomer(customer);
        }
    }

    private void importCars() {
        List<PartDto> parts = this.partsService.findAllPartsId();

        String debug = "";

        AddCarsWrapper addCarsWrapper = this.xmlSerializer.deserialize(AddCarsWrapper.class,
                Constants.INPUT_XML_FILES_PATH + Constants.INPUT_XML_CARS_FILE);

        Random random = new Random();
        List<PartDto> randomParts = new ArrayList<>();
        for (AddCarDto car : addCarsWrapper.getCars()) {

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

        AddPartsWrapper partsWrapper = this.xmlSerializer.deserialize(AddPartsWrapper.class,
                Constants.INPUT_XML_FILES_PATH + Constants.INPUT_XML_PARTS_FILE);

        Random rnd = new Random();
        for (AddPartDto part : partsWrapper.getParts()) {
            part.setSupplier(suppliers.get(rnd.nextInt(suppliers.size())));
            this.partsService.savePart(part);
        }
    }

    private void importSuppliers() {
        AddSuppliersWrapper suppliers = this.xmlSerializer.deserialize(AddSuppliersWrapper.class,
            Constants.INPUT_XML_FILES_PATH + Constants.INPUT_XML_SUPPLIERS_FILE);

        for (AddPartSupplierDto partSupplier : suppliers.getSuppliers()) {
            this.partSupplierService.savePartSupplier(partSupplier);
        }
    }


}
