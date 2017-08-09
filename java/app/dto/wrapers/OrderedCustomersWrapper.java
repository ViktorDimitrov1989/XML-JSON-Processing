package app.dto.wrapers;

import app.dto.views.OrderedCustomer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customers")
public class OrderedCustomersWrapper {

    @XmlElement(name = "customer")
    private List<OrderedCustomer> customers;

    public OrderedCustomersWrapper() {
    }

    public List<OrderedCustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<OrderedCustomer> customers) {
        this.customers = customers;
    }
}
