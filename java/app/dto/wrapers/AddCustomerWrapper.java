package app.dto.wrapers;

import app.dto.add.AddCustomerDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customers")
public class AddCustomerWrapper {

    @XmlElement(name = "customer")
    private List<AddCustomerDto> customers;

    public AddCustomerWrapper() {
    }

    public List<AddCustomerDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<AddCustomerDto> customers) {
        this.customers = customers;
    }
}
