package app.dto.wrapers;

import app.dto.views.OrderedCustomer;
import app.dto.views.SaleCustomer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customers")
public class SaleCustomerWrapper {

    @XmlElement(name = "customer")
    private List<SaleCustomer> customers;

    public SaleCustomerWrapper() {
    }

    public List<SaleCustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<SaleCustomer> customers) {
        this.customers = customers;
    }

}
