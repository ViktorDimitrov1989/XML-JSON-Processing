package app.services;

import app.dto.add.AddCustomerDto;
import app.dto.add.CustomerDto;
import app.dto.views.OrderedCustomer;
import app.dto.views.SaleCustomer;


import java.util.List;


public interface CustomerService {
    void saveCutomer(AddCustomerDto customer);

    List<CustomerDto> getCustomersToSet();

    List<OrderedCustomer>  findAllByOrderByBirthDateAsc();

    List<SaleCustomer> customersByBoughtCars();

}
