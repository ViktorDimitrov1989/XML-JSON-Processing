package app.services.impl;

import app.dto.add.AddCustomerDto;
import app.dto.add.CustomerDto;
import app.dto.views.OrderedCustomer;
import app.dto.views.SaleCustomer;
import app.models.Customer;
import app.models.Part;
import app.repositories.CustomerRepository;
import app.services.CustomerService;
import app.utils.DtoMappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveCutomer(AddCustomerDto customer) {
        this.customerRepository.saveAndFlush(DtoMappingUtil.convert(customer, Customer.class));
    }

    @Override
    public List<CustomerDto> getCustomersToSet() {
        return DtoMappingUtil.convert(this.customerRepository.findAll(), CustomerDto.class);
    }

    @Override
    public List<OrderedCustomer> findAllByOrderByBirthDateAsc() {
        return DtoMappingUtil.convert(this.customerRepository.findAllByOrderByBirthDateAsc(), OrderedCustomer.class);
    }

    @Override
    public List<SaleCustomer> customersByBoughtCars() {
        List<Customer> customers = this.customerRepository.customersByBoughtCars();
        List<SaleCustomer> res = new ArrayList<>();

        for (Customer customer : customers) {
            SaleCustomer c = new SaleCustomer();
            c.setBoughtCars(customer.getSales().size());
            c.setName(customer.getName());
            c.setSpentMoney(customer.getSales().stream()
                    .mapToDouble(s -> s.getCar().getParts().stream().mapToDouble(Part::getPrice).sum()).sum());

            res.add(c);
        }

        return res;
    }

}
